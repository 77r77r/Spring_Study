package com.iwon.hello_spring.service;

import com.iwon.hello_spring.domain.Member;
import com.iwon.hello_spring.repository.MemberRepository;
import com.iwon.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Transactional
public class MemberService {

    // 회원 리포지토리 필요
    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        // 외부에서 넣어주도록 변경 : DI(Dependency Injection
        this.memberRepository = memberRepository;
    }

    // 회원가입, 같은 이름이 있는 중복 회원X
    public Long join(Member member) {
        validateDuplicateMember(member);    // 중복회원 검증
        memberRepository.save(member);
        return member.getId();

        /* AOP 사용 전 시간측정 로직
        long start = System.currentTimeMillis();
        try {
            validateDuplicateMember(member);
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }*/
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체회원 조회하기
    public List<Member> findMembers() {
        return memberRepository.findAll();

        /* AOP 사용 전 시간측정 로직
        long start = System.currentTimeMillis();
        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers = " + timeMs + "ms");
        }*/
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);

        /* AOP 사용 전 시간측정 로직
        long start = System.currentTimeMillis();
        try {
        return memberRepository.findById(memberId);
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findOne = " + timeMs + "ms");
        }*/
    }
}
