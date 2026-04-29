package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.dto.LoginMemberDTO;


public class LoginMemberRowMapper implements RowMapper<LoginMemberDTO> {
	@Override
    public LoginMemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoginMemberDTO member = new LoginMemberDTO();

        member.setMemberId(rs.getLong("member_id"));
        member.setLoginId(rs.getString("login_id"));
        member.setName(rs.getString("name"));
        member.setRole(rs.getString("role"));
        member.setStatus(rs.getString("status"));
        

        return member;
    }
}
