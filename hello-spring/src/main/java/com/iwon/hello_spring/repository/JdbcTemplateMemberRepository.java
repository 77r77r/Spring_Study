package com.iwon.hello_spring.repository;

import com.iwon.hello_spring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JdbcTemplateMemberRepository implements MemberRepository{

    private final JdbcTemplate jdbcTemplate;

    // @Autowired   // 생성자가 하나일 땐 생략 가능
    public JdbcTemplateMemberRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        Map<String, Object> param = new HashMap<>();
        param.put("name", member.getName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(param));
        member.setId(key.longValue());
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        List<Member> result = jdbcTemplate.query("SELECT * FROM MEMBER WHERE ID = ?", memberRowMapper(),id);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = jdbcTemplate.query("SELECT * FROM MEMBER WHERE NAME = ?", memberRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("SELECT * FROM MEMBER", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper() {
       return (rs, rowNum) -> {
           Member member = new Member();
           member.setId(rs.getLong("id"));
           member.setName(rs.getString("name"));
           return member;
       };
       /* 람다로 변환 가능
       return new RowMapper<Member>() {
           @Override
           public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
               Member member = new Member();
               member.setId(rs.getLong("id"));
               member.setName(rs.getString("name"));
               return member;
           }
       }*/
    }
}
