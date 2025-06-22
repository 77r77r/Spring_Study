package com.iwon.basic.discount;

import com.iwon.basic.AppConfig;
import com.iwon.basic.Member.domain.Grade;
import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.service.MemberService;
import com.iwon.basic.order.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
class RateDiscountPolicyTest {

//    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    RateDiscountPolicy rateDiscountPolicy;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        rateDiscountPolicy = appConfig.discountPolicy();
    }

    @Test
    @DisplayName("VIP는 10% 할인 적용")
    void VIP_확인() {
        // given
        Member member = new Member(1L, "김브이", Grade.VIP);

        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 미적용")
    void VIP_아님() {
        // given
        Member member = new Member(1L, "김일반", Grade.BASIC);

        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(0);
    }
}