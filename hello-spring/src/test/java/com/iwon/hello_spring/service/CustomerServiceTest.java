package com.iwon.hello_spring.service;

import com.iwon.hello_spring.domain.Customer;
import com.iwon.hello_spring.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class CustomerServiceTest {

    @Autowired CustomerService customerService;
    @Autowired CustomerRepository customerRepository;

    @Test
    void 고객등록() {
        // given
        Customer customer = new Customer();
        customer.setName("김꼬리");
        customer.setAddress("대한민국");
        customer.setPhonenum("01012349999");

        // when
        Long save = customerService.save(customer);

        // then
        Customer findCustomer = customerService.findOne(save).get();
        Assertions.assertThat(customer.getName()).isEqualTo(findCustomer.getName());
    }
}
