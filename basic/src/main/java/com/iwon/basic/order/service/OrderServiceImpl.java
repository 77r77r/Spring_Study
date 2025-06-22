package com.iwon.basic.order.service;

import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.repository.MemberRepository;
import com.iwon.basic.Member.repository.MemoryMemberRepository;
import com.iwon.basic.discount.DiscountPolicy;
import com.iwon.basic.order.domain.Order;

public class OrderServiceImpl implements OrderService{

    // 회원 검색, 할인 정책 확인이 필요함
    /**
     * DIP, OCP 위반 : 인터페이스와 구현클래스를 둘다 호출하고 있기 때문이다. -> 인터페이스만 호출해야한다.
     * private final MemberRepository memberRepository = new MemoryMemberRepository();
     * private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
     * private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
     */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order cretaeOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 등급만 넘길지, 고객정보를 전체를 넘길지를 고려해서 선택(확장성을 위해 고객정보를 넘김)

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
