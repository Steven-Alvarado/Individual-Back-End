package StevenAlvaradoCS490.service.impl;

import StevenAlvaradoCS490.dto.CustomerDto;
import StevenAlvaradoCS490.dto.RentalDto;
import StevenAlvaradoCS490.entity.*;
import StevenAlvaradoCS490.exception.ResourceNotFoundException;
import StevenAlvaradoCS490.mapper.CustomerMapper;
import StevenAlvaradoCS490.repository.*;
import StevenAlvaradoCS490.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepository customerRepository;
    private StoreRepository storeRepository;
    private AddressRepository addressRepository;
    private RentalRepository rentalRepository;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    private static final Integer DEFAULT_STORE_ID = 1;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        // Step 1: Resolve or Create Store Entity
        Integer storeId = (customerDto.getStoreId() != null) ? customerDto.getStoreId() : DEFAULT_STORE_ID;
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found with ID: " + storeId));

        // Step 2: Resolve or Create Address, City, and Country
        Address address = resolveOrCreateAddress(customerDto);

        // Step 3: Map CustomerDto to Customer Entity
        Customer customer = CustomerMapper.mapToCustomer(customerDto, store, address);

        // Set default or auto-populated values
        customer.setCreateDate(LocalDateTime.now());
        customer.setLastUpdate(LocalDateTime.now());

        // Step 4: Save and Return CustomerDto
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    private Address resolveOrCreateAddress(CustomerDto customerDto) {
        // Resolve or create Country entity
        Country country = resolveOrCreateCountry(customerDto.getCountry());

        // Resolve or create City entity
        City city = resolveOrCreateCity(customerDto.getCity(), country);

        // Check if the address already exists
        return addressRepository.findByAddressAndCity(customerDto.getAddress(), city)
                .orElseGet(() -> {
                    Address newAddress = new Address();
                    newAddress.setAddress(customerDto.getAddress());
                    newAddress.setCity(city);
                    newAddress.setDistrict(customerDto.getDistrict());
                    newAddress.setPostalCode(customerDto.getPostalCode());
                    newAddress.setPhone(customerDto.getPhone());
                    newAddress.setLastUpdate(LocalDateTime.now());

                    return addressRepository.save(newAddress);
                });
    }

    private Country resolveOrCreateCountry(String countryName) {
        return countryRepository.findByCountry(countryName)
                .orElseGet(() -> {
                    Country country = new Country();
                    country.setCountry(countryName);
                    country.setLastUpdate(LocalDateTime.now());
                    return countryRepository.save(country);
                });
    }

    private City resolveOrCreateCity(String cityName, Country country) {
        return cityRepository.findByCityAndCountry(cityName, country)
                .orElseGet(() -> {
                    City city = new City();
                    city.setCity(cityName);
                    city.setCountry(country);
                    city.setLastUpdate(LocalDateTime.now());
                    return cityRepository.save(city);
                });
    }
    @Override
    public CustomerDto getCustomerById(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for ID: " + customerId));

        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map((customer) -> CustomerMapper.mapToCustomerDto(customer))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Integer customerId, CustomerDto updatedCustomer) {
        // Fetch the existing customer by ID
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for ID: " + customerId));

        // Update basic fields
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setLastUpdate(LocalDateTime.now());

        // Update store if a new store ID is provided
        if (updatedCustomer.getStoreId() != null) {
            Store store = storeRepository.findById(updatedCustomer.getStoreId())
                    .orElseThrow(() -> new ResourceNotFoundException("Store not found for ID: " + updatedCustomer.getStoreId()));
            customer.setStore(store);
        }

        // Update address if address details are provided
        if (updatedCustomer.getAddress() != null) {
            // Check if an existing address with the provided details exists or create a new one
            Address address = resolveOrCreateAddress(updatedCustomer);
            customer.setAddress(address);
        }

        // Save the updated customer entity
        Customer updatedCustomerObj = customerRepository.save(customer);

        // Return the updated CustomerDto
        return CustomerMapper.mapToCustomerDto(updatedCustomerObj);
    }


// Assume resolveOrCreateCountry and resolveOrCreateCity methods are defined as before


    public List<Rental> getCustomerRentals(Integer customerId) {
        List<Rental> rentals = rentalRepository.findByCustomerCustomerId(customerId);
        if (rentals.isEmpty()) {
            throw new EntityNotFoundException("No rentals found for Customer ID: " + customerId);
        }
        return rentals;
    }

    public Rental markRentalAsReturned(Integer rentalId){
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new EntityNotFoundException("Rental not found"));
        rental.setReturnDate(LocalDateTime.now());
        return rentalRepository.save(rental);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found for ID: " + customerId)
        );

        customerRepository.deleteById(customerId);
    }

    public List<RentalDto> getCustomerRentalsAsDto(Integer customerId) {
        List<Rental> rentals = rentalRepository.findByCustomerCustomerId(customerId);
        return rentals.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private RentalDto convertToDto(Rental rental) {
        RentalDto dto = new RentalDto();
        dto.setRentalId(rental.getRentalId());
        dto.setRentalDate(rental.getRentalDate());
        dto.setReturnDate(rental.getReturnDate());
        dto.setLastUpdate(rental.getLastUpdate());
        dto.setFilmTitle(rental.getInventory().getFilm().getTitle());


        return dto;
    }
}
