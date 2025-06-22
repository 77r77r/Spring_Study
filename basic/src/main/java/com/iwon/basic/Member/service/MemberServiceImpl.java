package com.iwon.basic.Member.service;

import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.repository.MemberRepository;
import com.iwon.basic.Member.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;
    // AppConfig 관련 수정, 생성자를 통해서 구현체를 할당하겠다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.join(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
