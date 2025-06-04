package com.iwon.hello_spring.controller;

import com.iwon.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // 생성자 주입방식 : 요즘 추천하는 방식
    private final MemberService memberService;

    @Autowired  // 스프링 컨테이너에 있는 객체와 연결을 시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /*
    // 필드 주입방식
    @Autowired private MemberService memberService;

    // Setter 주입방식 : 누군가 멤버 컨트롤러를 호출 했을 때 public 으로 열려있어야함, 한 번 세팅되면 바꿀일이 없어서 public으로 노출할 이유가 없는데 강제로 노출되는 것, 호출하지 말아야할 메소드가 호출되면 안됨
    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
    */

}
