package com.iwon.basic;

import com.iwon.basic.Member.domain.Grade;
import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.service.MemberService;
import com.iwon.basic.Member.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        /**
         * MemberService memberService = new MemberServiceImpl();
         * 기존에는 객체를 직접 생성했지만, AppConfig를 이용해 호출한다.
         */
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "김일번", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
