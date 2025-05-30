package com.iwon.hello_spring.service;

import com.iwon.hello_spring.domain.Member;
import com.iwon.hello_spring.repository.MemberRepository;
import com.iwon.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    /*
     * MemoryMemberRepository에서 static은 클래스 레벨에 붙는 거라 지금은 상관 없지만
     * new는 다른 인스턴스이기 때문에 내용물이 달라지거나 할 수 있어서, 수정하는 게 좋음
     * MemberService.java 소스 코드 수정 ->
     *
     * // Before
     * MemberService memberService = new MemberService();
     * MemoryMemberRepository memberRepository = new MemoryMemberRepository();
     */

    // After
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);

    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        // 저장한게 리포지토리에 맞아?

        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        // '->' 이후 로직(memberService.join(member2))을 실행했을 때, 앞에 있는 예외(IllegalStateException)가 터져야 한다.
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // 검증 방법
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123");
        }
*/
        // then
    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}