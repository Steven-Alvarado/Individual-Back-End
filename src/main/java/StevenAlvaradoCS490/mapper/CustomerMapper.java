package StevenAlvaradoCS490.mapper;

import StevenAlvaradoCS490.dto.CustomerDto;
import StevenAlvaradoCS490.dto.RentalDto;
import StevenAlvaradoCS490.entity.Address;
import StevenAlvaradoCS490.entity.Customer;
import StevenAlvaradoCS490.entity.Rental;
import StevenAlvaradoCS490.entity.Store;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer) {
        if (customer == null) {
            return null;
        }

        return new CustomerDto(
                customer.getCustomerId(),
                customer.getStore() != null ? customer.getStore().getStoreId() : null,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),

                // Address fields with null checks
                customer.getAddress() != null ? customer.getAddress().getAddress() : null,  // Street
                customer.getAddress() != null && customer.getAddress().getCity() != null
                        ? customer.getAddress().getCity().getCity() : null,                // City
                customer.getAddress() != null && customer.getAddress().getCity() != null &&
                        customer.getAddress().getCity().getCountry() != null
                        ? customer.getAddress().getCity().getCountry().getCountry() : null, // Country
                customer.getAddress() != null ? customer.getAddress().getPostalCode() : null,
                customer.getAddress() != null ? customer.getAddress().getPhone() : null,

                // Map rentals
                mapToRentalDtoList(customer.getRentals()),

                customer.getCreateDate(),
                customer.getLastUpdate()
        );
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Store store, Address address) {
        return new Customer(
                null,  // customerId set to null for auto-increment on creation
                store,
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                address,
                null,  // Rentals to be handled separately
                customerDto.getCreateDate(),
                customerDto.getLastUpdate()
        );
    }

    // Helper method to map List<Rental> to List<RentalDto>
    private static List<RentalDto> mapToRentalDtoList(List<Rental> rentals) {
        return rentals != null
                ? rentals.stream().map(RentalMapper::mapToRentalDto).collect(Collectors.toList())
                : Collections.emptyList();
    }
}
