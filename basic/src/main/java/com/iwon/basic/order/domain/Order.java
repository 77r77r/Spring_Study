package com.iwon.basic.order.domain;

public class Order {

    private Long memberId;  // 주문고객Id
    private String itemName; // 상품명
    private int itemPrice;   // 상품 가격
    private int discountPrice;  // 할인 금액

    public Order(Long memberId, String productName, int productPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = productName;
        this.itemPrice = productPrice;
        this.discountPrice = discountPrice;
    }

    /**
     * @return 할인된 최종 금액
     */
    public int calcPrice() {
        return itemPrice - discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * System.out.println("order= " + order);
     * 사용시 아래 toString()이 호출됨
     */
    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
