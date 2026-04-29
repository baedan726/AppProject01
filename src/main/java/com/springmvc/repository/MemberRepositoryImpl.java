package com.springmvc.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.dto.FindIdDTO;
import com.springmvc.dto.FindPwDTO;
import com.springmvc.dto.LoginDTO;
import com.springmvc.dto.LoginMemberDTO;
import com.springmvc.dto.MemberManagementDTO;
import com.springmvc.dto.MemberUpdateDTO;
import com.springmvc.dto.PwChangeDTO;
import com.springmvc.dto.SignupDTO;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource datasource) {
		this.template= new JdbcTemplate(datasource);
	}
	// 로그인
    @Override
    public LoginMemberDTO login(LoginDTO loginDTO) {
        String sql = "SELECT * FROM MEMBER WHERE login_id = ? AND password = ? AND status = 'ACTIVE'";

        return template.queryForObject(
                sql, new LoginMemberRowMapper(),loginDTO.getId(),loginDTO.getPw()
        );
    }
	@Override
	public void signup(SignupDTO signupDTO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String findId(FindIdDTO findIdDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int findPw(FindPwDTO findPwDTO) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void changePassword(Long memberId, PwChangeDTO pwChangeDTO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemberManagementDTO findByMemberId(Long memberId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateMember(Long memberId, MemberUpdateDTO memberUpdateDTO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberManagementDTO> findAllMembers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteMember(Long memberId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateMemberStatus(Long memberId, String status) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int countById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int countByEmail(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

}
