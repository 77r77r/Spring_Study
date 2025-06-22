package com.iwon.basic;

import com.iwon.basic.Member.domain.Grade;
import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.service.MemberService;
import com.iwon.basic.Member.service.MemberServiceImpl;
import com.iwon.basic.order.domain.Order;
import com.iwon.basic.order.service.OrderService;
import com.iwon.basic.order.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        /**
         * MemberService memberService = new MemberServiceImpl();
         * OrderService orderService = new OrderServiceImpl();
         * 기존에는 객체를 직접 생성했지만, AppConfig를 이용해 호출한다.
         */
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "김브이", Grade.VIP);
        memberService.join(member);

        Order order = orderService.cretaeOrder(memberId, "포카칩", 18000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calcPrice());
    }
}
