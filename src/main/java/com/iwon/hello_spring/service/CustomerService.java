package com.iwon.hello_spring.service;

import com.iwon.hello_spring.domain.Customer;
import com.iwon.hello_spring.repository.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Long save(Customer customer) {
        customerRepository.save(customer);
        return customer.getId();
    }

    public Optional<Customer> findOne(Long id) {
        return customerRepository.findById(id);
    }
}
