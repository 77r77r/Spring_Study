package com.iwon.basic.order.service;

import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.repository.MemberRepository;
import com.iwon.basic.Member.repository.MemoryMemberRepository;
import com.iwon.basic.discount.domain.DiscountPolicy;
import com.iwon.basic.discount.domain.FixDiscountPolicy;
import com.iwon.basic.order.domain.Order;

public class OrderServiceImpl implements OrderService{

    // 회원 검색, 할인 정책 확인이 필요함
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order cretaeOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 등급만 넘길지, 고객정보를 전체를 넘길지를 고려해서 선택(확장성을 위해 고객정보를 넘김)

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
