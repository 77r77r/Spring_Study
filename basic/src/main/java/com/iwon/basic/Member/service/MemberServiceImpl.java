package com.iwon.basic.Member.service;

import com.iwon.basic.Member.domain.Member;
import com.iwon.basic.Member.repository.MemberRepository;
import com.iwon.basic.Member.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.join(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
