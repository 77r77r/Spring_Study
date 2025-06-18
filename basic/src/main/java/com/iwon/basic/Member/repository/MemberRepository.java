package com.iwon.basic.Member.repository;

import com.iwon.basic.Member.domain.Member;

public interface MemberRepository {

    void join(Member member);   // 회원가입
    Member findById(Long memberId); // 회원조회(ID)
}
