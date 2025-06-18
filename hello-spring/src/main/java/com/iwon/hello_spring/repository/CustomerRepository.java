package com.iwon.hello_spring.repository;

import com.iwon.hello_spring.domain.Customer;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class CustomerRepository {

    private final EntityManager em;

    public CustomerRepository(EntityManager em) {
        this.em = em;
    }

    public Customer save(Customer customer) {
        em.persist(customer);
        return customer;
    }

    public Optional<Customer> findById(Long id) {
        Customer customer = em.find(Customer.class, id);
        return Optional.ofNullable(customer);
    }

}
