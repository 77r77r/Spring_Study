package com.iwon.hello_spring.service;

import com.iwon.hello_spring.domain.Member;
import com.iwon.hello_spring.repository.MemberRepository;
import com.iwon.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class MemberService {

    // 회원 리포지토리 필요
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        // 외부에서 넣어주도록 변경 : DI(Dependency Injection
        this.memberRepository = memberRepository;
    }

    /*
     * 회원가입,
     * 같은 이름이 있는 중복 회원X
     */
    public Long join(Member member) {

//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {   //null이 아니라 값이 있으면 동작, if != null 과 동일한 로직
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        //result.orElseGet(); // 사용. 값이 있으면 꺼내고 없으면 메서드 실행
        // 위와 동일한 코드지만 한줄로 정리가능하지만 메서드로 뽑는 게 좋음
//        memberRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });

        validateDuplicateMember(member);    // 중복회원 검증

        memberRepository.save(member);
        return member.getId();
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
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
