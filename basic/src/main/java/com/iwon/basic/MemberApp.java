package com.iwon.basic;

import com.iwon.basic.Member.domain.Grade;
import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.service.MemberService;
import com.iwon.basic.Member.service.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        /**
         * 1. 객체를 직접 생성
         * MemberService memberService = new MemberServiceImpl();
         */

        /**
         * 2. AppConfig를 이용해 호출
         * AppConfig appConfig = new AppConfig();
         * MemberService memberService = appConfig.memberService();
         */

        /**
         * 3. Spring Bean으로 호출
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 메서드 이름, Type

        Member member = new Member(1L, "김일번", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
