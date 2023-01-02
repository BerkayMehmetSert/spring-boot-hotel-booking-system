package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.CustomerDto;
import com.bms.hotelbookingsystem.dto.converter.CustomerDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateCustomerRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateCustomerAddressRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateCustomerRequest;
import com.bms.hotelbookingsystem.exception.CustomerAlreadyExistException;
import com.bms.hotelbookingsystem.exception.CustomerNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.Customer;
import com.bms.hotelbookingsystem.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    public void createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer();

        checkIfCustomerExistsByNationalId(request.getNationalId());
        checkIfCustomerExistsByPassportId(request.getPassportId());

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setNationalId(request.getNationalId());
        customer.setPassportId(request.getPassportId());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setCountry(request.getCountry());
        customer.setZipCode(request.getZipCode());
        customer.setCreatedAt(DateHelper.getCurrentDate());
        customer.setUpdatedAt(DateHelper.getCurrentDate());

        customerRepository.save(customer);
        log.info(BusinessLogMessage.Customer.CUSTOMER_CREATED);
    }

    public void updateCustomer(final String id, UpdateCustomerRequest request) {
        Customer customer = findCustomerByCustomerId(id);

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setCountry(request.getCountry());
        customer.setZipCode(request.getZipCode());
        customer.setUpdatedAt(DateHelper.getCurrentDate());

        customerRepository.save(customer);
        log.info(BusinessLogMessage.Customer.CUSTOMER_UPDATED + id);
    }

    public void updateCustomerAddress(final String id, UpdateCustomerAddressRequest request){
        Customer customer = findCustomerByCustomerId(id);

        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setCountry(request.getCountry());
        customer.setZipCode(request.getZipCode());
        customer.setUpdatedAt(DateHelper.getCurrentDate());

        customerRepository.save(customer);
        log.info(BusinessLogMessage.Customer.CUSTOMER_ADDRESS_UPDATED + id);
    }

    public void deleteCustomer(final String id) {
        Customer customer = findCustomerByCustomerId(id);

        customerRepository.delete(customer);
        log.info(BusinessLogMessage.Customer.CUSTOMER_DELETED + id);
    }

    public CustomerDto findCustomerById(final String id) {
        Customer customer = findCustomerByCustomerId(id);

        log.info(BusinessLogMessage.Customer.CUSTOMER_FOUND + id);
        return converter.convert(customer);
    }

    public List<CustomerDto> findAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        if (customerList.isEmpty()) {
            log.error(BusinessLogMessage.Customer.CUSTOMER_LIST_EMPTY);
            throw new CustomerNotFoundException(BusinessMessage.Customer.CUSTOMER_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Customer.CUSTOMER_LISTED);
        return converter.convert(customerList);
    }

    private void checkIfCustomerExistsByNationalId(final String nationalId) {
        if (customerRepository.existsByNationalId(nationalId)) {
            log.error(BusinessLogMessage.Customer.CUSTOMER_ALREADY_EXISTS + nationalId);
            throw new CustomerAlreadyExistException(BusinessMessage.Customer.CUSTOMER_ALREADY_EXIST);
        }
        if (customerRepository.existsByPassportId(nationalId)) {
            log.error(BusinessLogMessage.Customer.CUSTOMER_ALREADY_EXISTS + nationalId);
            throw new CustomerAlreadyExistException(BusinessMessage.Customer.CUSTOMER_ALREADY_EXIST);
        }
    }

    private void checkIfCustomerExistsByPassportId(final String passportId) {
        if (customerRepository.existsByPassportId(passportId)) {
            log.error(BusinessLogMessage.Customer.CUSTOMER_ALREADY_EXISTS + passportId);
            throw new CustomerAlreadyExistException(BusinessMessage.Customer.CUSTOMER_ALREADY_EXIST);
        }
    }

    protected Customer findCustomerByCustomerId(final String id) {
        return customerRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Customer.CUSTOMER_NOT_FOUND + id);
            throw new CustomerNotFoundException(BusinessMessage.Customer.CUSTOMER_NOT_FOUND);
        });
    }
}
