package com.iwon.hello_spring.repository;

import com.iwon.hello_spring.domain.Member;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcMemberRepository implements MemberRepository{

    private final DataSource dataSource;
    private static final String SAVE = "INSERT INTO MEMBER(NAME) VALUES(?)";
    private static final String FIND_BY_ID = "SELECT * FROM MEMBER WHERE ID = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM MEMBER WHERE NAME = ?";
    private static final String FIND_ALL = "SELECT * FROM MEMBER";

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;    // 결과 받아오기

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(SAVE, PreparedStatement.RETURN_GENERATED_KEYS); // RETURN_GENERATED_KEYS : DB에 AUTO_INCREMENT로 인해 자동으로 생성되어진 key(=id)를 가져오는 쿼리

            pstmt.setString(1, member.getName()); // 쿼리 세팅

            pstmt.executeUpdate(); // 쿼리 전달
            rs = pstmt.getGeneratedKeys();  // RETURN_GENERATED_KEYS 옵션과 매칭되서 키 값을 받아온다

            if (rs.next()) {
                member.setId(rs.getLong(1));
            } else {
                throw new SQLException("ID 조회 실패");
            }

            return member;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs); // DB 종료 필수
        }
    }

    @Override
    public Optional<Member> findById(Long id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;    // 결과 받아오기

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setLong(1, id);

            rs = pstmt.executeQuery();  // 쿼리 조회

            if(rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                return Optional.of(member);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Member> findByName(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(FIND_BY_NAME);

            pstmt.setString(1, name);

            rs = pstmt.executeQuery();
            if(rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                return Optional.of(member);
            }

            return Optional.empty();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Member> findAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            List<Member> members = new ArrayList<>();
            while(rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                members.add(member);
            }

            return members;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
        // 데이터소스유틸스를 통해서 커넥션을 해야 트랙잭션에 걸렸을 때 유지 시켜줌 : 스프링 쓸때는 꼭
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}
