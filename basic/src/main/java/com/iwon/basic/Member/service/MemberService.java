package com.iwon.basic.Member.service;

import com.iwon.basic.Member.domain.Member;

public interface MemberService {

    void join(Member member);   // 회원가입
    Member findMember(Long memberId);   // 회원조회(ID)
}
