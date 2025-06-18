package com.iwon.basic;

import com.iwon.basic.Member.domain.Grade;
import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.service.MemberService;
import com.iwon.basic.Member.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "김일번", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
