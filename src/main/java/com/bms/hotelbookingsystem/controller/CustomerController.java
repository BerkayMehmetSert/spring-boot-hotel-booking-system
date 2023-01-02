package com.bms.hotelbookingsystem.controller;

import com.bms.hotelbookingsystem.dto.CustomerDto;
import com.bms.hotelbookingsystem.dto.request.CreateCustomerRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateCustomerAddressRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateCustomerRequest;
import com.bms.hotelbookingsystem.helper.message.ControllerLogMessage;
import com.bms.hotelbookingsystem.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@Slf4j
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);

        log.info(ControllerLogMessage.Customer.CUSTOMER_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable String id, @RequestBody UpdateCustomerRequest request) {
        customerService.updateCustomer(id, request);

        log.info(ControllerLogMessage.Customer.CUSTOMER_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<Void> updateCustomerAddress(@PathVariable String id,
                                                      @RequestBody UpdateCustomerAddressRequest request) {
        customerService.updateCustomerAddress(id, request);

        log.info(ControllerLogMessage.Customer.CUSTOMER_ADDRESS_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);

        log.info(ControllerLogMessage.Customer.CUSTOMER_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable String id) {
        CustomerDto customer = customerService.findCustomerById(id);

        log.info(ControllerLogMessage.Customer.CUSTOMER_FOUND + id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAllCustomers() {
        List<CustomerDto> customerList = customerService.findAllCustomers();

        log.info(ControllerLogMessage.Customer.CUSTOMER_LISTED);
        return ResponseEntity.ok(customerList);
    }
}
