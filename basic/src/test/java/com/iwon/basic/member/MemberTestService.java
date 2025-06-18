package com.iwon.basic.member;

import com.iwon.basic.Member.domain.Grade;
import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.service.MemberService;
import com.iwon.basic.Member.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberTestService {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given : 이런 게 주어졌을 때
        Member member = new Member(1L, "노미로", Grade.VIP);

        //when : 이렇게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then : 이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
