package StevenAlvaradoCS490.controller;

import StevenAlvaradoCS490.dto.CustomerDto;
import StevenAlvaradoCS490.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    //POST create customer REST API
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    //GET customer REST API
    @GetMapping("{customer_id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customer_id") Integer customerId) {
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customerDto);
    }

    //GET all customers REST API
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto>   customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    //PUT update customer REST API
    @PutMapping("{customer_id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customer_id") Integer customerId,
                                                      @RequestBody CustomerDto updatedCustomer) {
        CustomerDto customerDto = customerService.updateCustomer(customerId, updatedCustomer);
        return ResponseEntity.ok(customerDto);
    }

    //DELETE customer REST API
    @DeleteMapping("{customer_id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customer_id") Integer customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer with ID: " + customerId + " deleted successfully");
    }
}
