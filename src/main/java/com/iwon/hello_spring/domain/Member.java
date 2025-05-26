package com.iwon.hello_spring.domain;

public class Member {

    private Long id;        // 시스템에서 사용하는 ID
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