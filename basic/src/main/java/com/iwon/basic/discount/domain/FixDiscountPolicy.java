package com.iwon.basic.discount.domain;

import com.iwon.basic.Member.domain.Grade;
import com.iwon.basic.Member.domain.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int DISCOUNT_FIX_AMOUNT = 1000;   // 고정할인 금액 : 1000원 할인

    @Override
    public int discount(Member member, int price) {
        // 등급이 VIP인 경우만 할인
        if (member.getGrade() == Grade.VIP) {   // Enum 타입은 == 을 사용해 비교
            return DISCOUNT_FIX_AMOUNT;
        } else {
            return 0;
        }
    }
}
