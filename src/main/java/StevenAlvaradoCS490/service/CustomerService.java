package StevenAlvaradoCS490.service;

import StevenAlvaradoCS490.dto.CustomerDto;
import StevenAlvaradoCS490.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(Integer id);

    List<CustomerDto> getAllCustomers();

    CustomerDto updateCustomer(Integer customerId, CustomerDto updatedCustomer);

    void deleteCustomer(Integer customerId);
}
