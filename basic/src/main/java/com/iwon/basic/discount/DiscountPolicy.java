package com.iwon.basic.discount;

import com.iwon.basic.Member.domain.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
