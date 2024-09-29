package StevenAlvaradoCS490.service.impl;

import StevenAlvaradoCS490.dto.CustomerDto;
import StevenAlvaradoCS490.entity.Customer;
import StevenAlvaradoCS490.exception.ResourceNotFoundException;
import StevenAlvaradoCS490.mapper.CustomerMapper;
import StevenAlvaradoCS490.repository.CustomerRepository;
import StevenAlvaradoCS490.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
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
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for ID: " + customerId)
        );
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setActive(updatedCustomer.getActive());
        customer.setAddressId(updatedCustomer.getAddressId());
        customer.setLastUpdate(updatedCustomer.getLastUpdate());

        Customer updatedCustomerObj = customerRepository.save(customer);
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
