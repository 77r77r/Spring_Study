package com.iwon.hello_spring.controller;

public class MemberForm {
    private String name;    // createMemberForm.html 의 name과 매칭이 되어 값이 들어옴

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
