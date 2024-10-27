package StevenAlvaradoCS490.service;

import StevenAlvaradoCS490.dto.CustomerDto;
import StevenAlvaradoCS490.dto.RentalDto;
import StevenAlvaradoCS490.entity.Customer;
import StevenAlvaradoCS490.entity.Rental;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(Integer id);

    List<CustomerDto> getAllCustomers();

    CustomerDto updateCustomer(Integer customerId, CustomerDto updatedCustomer);

    void deleteCustomer(Integer customerId);

    List<Rental> getCustomerRentals(Integer customerId);

    Rental markRentalAsReturned(Integer rentalId);

    List<RentalDto> getCustomerRentalsAsDto(Integer customerId);

}
