package com.iwon.hello_spring;

import com.iwon.hello_spring.repository.*;
import com.iwon.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    // 스프링 데이터 JPA
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


    /*********************
     // JPA 사용코드
     @PersistenceContext
     private EntityManager em;

     @Autowired
     public SpringConfig(EntityManager em) {
     this.em = em;
     }

     @Bean
     public MemberService memberService() {
     return new MemberService(memberRepository());
     }

     @Bean
     public MemberRepository memberRepository() {
     return new JpaMemberRepository(em);
     }
     *********************/


    /*********************
    // JDBC 일때 사용 코드
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
     *********************/
}
