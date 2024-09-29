package StevenAlvaradoCS490.mapper;

import StevenAlvaradoCS490.dto.CustomerDto;
import StevenAlvaradoCS490.entity.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer) {
       return new CustomerDto(

               customer.getCustomerId(),
               customer.getStoreId(),
               customer.getFirstName(),
               customer.getLastName(),
               customer.getEmail(),
               customer.getAddressId(),
               customer.getActive(),
               customer.getCreateDate(),
               customer.getLastUpdate()


       );
    }

    public static Customer mapToCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.getCustomerId(),
                customerDto.getStoreId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getAddressId(),
                customerDto.getActive(),
                customerDto.getCreatDate(),
                customerDto.getLastUpdate()
        );
    }
}
