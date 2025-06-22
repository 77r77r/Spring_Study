package com.iwon.basic;

import com.iwon.basic.Member.domain.Grade;
import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.service.MemberService;
import com.iwon.basic.Member.service.MemberServiceImpl;
import com.iwon.basic.order.domain.Order;
import com.iwon.basic.order.service.OrderService;
import com.iwon.basic.order.service.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        /**
         * 1. 객체를 직접 생성
         * MemberService memberService = new MemberServiceImpl();
         * OrderService orderService = new OrderServiceImpl();
         */

        /**
         * 2. AppConfig를 이용해 호출한다.
         * AppConfig appConfig = new AppConfig();
         * MemberService memberService = appConfig.memberService();
         * OrderService orderService = appConfig.orderService();
         */

        /**
         * 3. Spring Bean으로 호출
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "김브이", Grade.VIP);
        memberService.join(member);

        Order order = orderService.cretaeOrder(memberId, "포카칩", 18000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calcPrice());
    }
}
