package StevenAlvaradoCS490.mapper;

import StevenAlvaradoCS490.dto.CustomerDto;
import StevenAlvaradoCS490.dto.RentalDto;
import StevenAlvaradoCS490.entity.Address;
import StevenAlvaradoCS490.entity.Customer;
import StevenAlvaradoCS490.entity.Rental;
import StevenAlvaradoCS490.entity.Store;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer) {
       return new CustomerDto(

               customer.getCustomerId(),
               customer.getStore() != null ? customer.getStore().getStoreId() : null,
               customer.getFirstName(),
               customer.getLastName(),
               customer.getEmail(),
               customer.getAddress() != null ? customer.getAddress().getAddressId() : null,
               customer.getRentals() != null ? mapToRentalDtoList(customer.getRentals()) : null,  // Check for null rentals
               customer.getCreateDate(),
               customer.getLastUpdate()


       );
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Store store, Address address) {
        return new Customer(
                null,//customerDto.getCustomerId(), null to allow auto-increment
                store,
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                address,
                null,
                customerDto.getCreateDate(),
                customerDto.getLastUpdate()
        );
    }

    // Helper method to map List<Rental> to List<RentalDto>
    private static List<RentalDto> mapToRentalDtoList(List<Rental> rentals) {
        return rentals.stream()
                .map(RentalMapper::mapToRentalDto)  // Assuming you have a RentalMapper
                .collect(Collectors.toList());
    }
}
