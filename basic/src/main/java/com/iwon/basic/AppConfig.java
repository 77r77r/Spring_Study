package com.iwon.basic;

import com.iwon.basic.Member.repository.MemberRepository;
import com.iwon.basic.Member.repository.MemoryMemberRepository;
import com.iwon.basic.Member.service.MemberService;
import com.iwon.basic.Member.service.MemberServiceImpl;
import com.iwon.basic.discount.DiscountPolicy;
import com.iwon.basic.discount.FixDiscountPolicy;
import com.iwon.basic.discount.RateDiscountPolicy;
import com.iwon.basic.order.service.OrderService;
import com.iwon.basic.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
