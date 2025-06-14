package com.iwon.hello_spring.controller;

import com.iwon.hello_spring.domain.Customer;
import com.iwon.hello_spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/new")
    public String createForm() {
        return "customer/createCustomerForm";
    }

    @PostMapping("/customer/new")
    public String create(CustomerForm form) {
        Customer customer = new Customer();
        customer.setName(form.getName());
        customer.setAddress(form.getAddress());
        customer.setPhonenum((form.getPhonenum()));

        customerService.save(customer);

        return "redirect:/";
    }
}
