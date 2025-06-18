package com.iwon.hello_spring.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알서 생성해주는 것 = IDENTITY
    private Long id;        // 시스템에서 사용하는 ID

    @Column(name="name")
    private String name;    // 고객명

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
}