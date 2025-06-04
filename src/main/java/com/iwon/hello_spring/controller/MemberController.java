package com.iwon.hello_spring.controller;

import com.iwon.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    // new로 생성하면 여러개의 인스턴스를 생성할 필요가 없으면 new 보다 스프링 컨테이너에 등록하고 사용하는 게 좋음.(하나 생성으로 공용사용) 스프링 컨테이너는 딱 하나만 등록이 됨. + 알파기능은 다음에

    @Autowired  // 스프링 컨테이너에 있는 객체와 연결을 시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }



//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
}
