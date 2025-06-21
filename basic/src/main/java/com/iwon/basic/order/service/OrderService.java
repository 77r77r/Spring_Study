package com.iwon.basic.order.service;

import com.iwon.basic.order.domain.Order;

public interface OrderService {
    /**
     * 1. 주문 생성
     * @param memberId 회원id
     * @param itemName 상품명
     * @param itemPrice 상품 가격
     * @return 주문결과 반환
     */
    Order cretaeOrder(Long memberId, String itemName, int itemPrice);

}
