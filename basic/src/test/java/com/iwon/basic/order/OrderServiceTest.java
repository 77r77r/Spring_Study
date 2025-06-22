package com.iwon.basic.order;

import com.iwon.basic.AppConfig;
import com.iwon.basic.Member.domain.Grade;
import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.service.MemberService;
import com.iwon.basic.Member.service.MemberServiceImpl;
import com.iwon.basic.order.domain.Order;
import com.iwon.basic.order.service.OrderService;
import com.iwon.basic.order.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void 주문() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "김브이", Grade.VIP);
        memberService.join(member);

        // when : 주문을 생성했을 때
        Order order = orderService.cretaeOrder(memberId, "참크래커", 2500);

        // then : VIP이면 1000원 할인
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
