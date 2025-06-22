package com.iwon.basic;

import com.iwon.basic.Member.repository.MemoryMemberRepository;
import com.iwon.basic.Member.service.MemberService;
import com.iwon.basic.Member.service.MemberServiceImpl;
import com.iwon.basic.discount.DiscountPolicy;
import com.iwon.basic.discount.FixDiscountPolicy;
import com.iwon.basic.discount.RateDiscountPolicy;
import com.iwon.basic.order.service.OrderService;
import com.iwon.basic.order.service.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

    public RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
