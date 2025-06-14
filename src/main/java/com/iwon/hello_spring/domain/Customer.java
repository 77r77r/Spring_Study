package com.iwon.hello_spring.domain;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO) // GenerationType.IDENTITY?
    private Long id;            // 내부 고객번호

    @Column(name="name")
    private String name;        // 고객 이름

    @Column(name="address")
    private String address;     // 고객 주소

    @Column(name="phonenum")
    private String phonenum;    // 고객 전화번호

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
}
