package StevenAlvaradoCS490.service.impl;

import StevenAlvaradoCS490.dto.CustomerDto;
import StevenAlvaradoCS490.entity.Address;
import StevenAlvaradoCS490.entity.Customer;
import StevenAlvaradoCS490.entity.Store;
import StevenAlvaradoCS490.exception.ResourceNotFoundException;
import StevenAlvaradoCS490.mapper.CustomerMapper;
import StevenAlvaradoCS490.repository.AddressRepository;
import StevenAlvaradoCS490.repository.CustomerRepository;
import StevenAlvaradoCS490.repository.StoreRepository;
import StevenAlvaradoCS490.service.CustomerService;
import lombok.AllArgsConstructor;
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

    private static final Integer DEFAULT_STORE_ID = 1;
    private static final Integer DEFAULT_ADDRESS_ID = 1;
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {


        // Check if the storeId is provided, otherwise use default
        Integer storeId = (customerDto.getStoreId() != null) ? customerDto.getStoreId() : DEFAULT_STORE_ID;

        // Check if the addressId is provided, otherwise use default
        Integer addressId = (customerDto.getAddressId() != null) ? customerDto.getAddressId() : DEFAULT_ADDRESS_ID;

        // Fetch the Store entity using the resolved storeId
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found with ID: " + storeId));

        // Fetch the Address entity using the resolved addressId
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with ID: " + addressId));        // Map CustomerDto to Customer entity, passing the Store and Address entities
        Customer customer = CustomerMapper.mapToCustomer(customerDto, store, address);

        //default values for store id and address id

        customer.setCreateDate(LocalDateTime.now());
        customer.setLastUpdate(LocalDateTime.now());

        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
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

        // Update the fields
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setEmail(updatedCustomer.getEmail());

        // Set lastUpdate to current time
        customer.setLastUpdate(LocalDateTime.now());

        // If store or address might be updated, handle it here
        if (updatedCustomer.getStoreId() != null) {
            Store store = storeRepository.findById(updatedCustomer.getStoreId())
                    .orElseThrow(() -> new ResourceNotFoundException("Store not found for ID: " + updatedCustomer.getStoreId()));
            customer.setStore(store);
        }

        if (updatedCustomer.getAddressId() != null) {
            Address address = addressRepository.findById(updatedCustomer.getAddressId())
                    .orElseThrow(() -> new ResourceNotFoundException("Address not found for ID: " + updatedCustomer.getAddressId()));
            customer.setAddress(address);
        }

        // Save the updated customer entity
        Customer updatedCustomerObj = customerRepository.save(customer);

        // Return the updated CustomerDto
        return CustomerMapper.mapToCustomerDto(updatedCustomerObj);
    }


    @Override
    public void deleteCustomer(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found for ID: " + customerId)
        );

        customerRepository.deleteById(customerId);
    }
}
