package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dto.FindIdDTO;
import com.springmvc.dto.FindPwDTO;
import com.springmvc.dto.LoginDTO;
import com.springmvc.dto.LoginMemberDTO;
import com.springmvc.dto.MemberManagementDTO;
import com.springmvc.dto.MemberUpdateDTO;
import com.springmvc.dto.PwChangeDTO;
import com.springmvc.dto.SignupDTO;
import com.springmvc.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memberRepository;
	
	
	@Override
	public LoginMemberDTO login(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return memberRepository.login(loginDTO);
	}

	@Override
	public void signup(SignupDTO signupDTO) {
		// TODO Auto-generated method stub
		memberRepository.signup(signupDTO);
	}

	@Override
	public String findId(FindIdDTO findIdDTO) {
		// TODO Auto-generated method stub
		return memberRepository.findId(findIdDTO);
	}

	@Override
	public int findPw(FindPwDTO findPwDTO) {
		// TODO Auto-generated method stub
		return memberRepository.findPw(findPwDTO);
	}

	@Override
	public void changePassword(Long memberId, PwChangeDTO pwChangeDTO) {
		// TODO Auto-generated method stub
		memberRepository.changePassword(memberId, pwChangeDTO);
	}

	@Override
	public MemberManagementDTO findByMemberId(Long memberId) {
		// TODO Auto-generated method stub
		return memberRepository.findByMemberId(memberId);
	}

	@Override
	public void updateMember(Long memberId, MemberUpdateDTO memberUpdateDTO) {
		// TODO Auto-generated method stub
		memberRepository.updateMember(memberId, memberUpdateDTO);
	}

	@Override
	public List<MemberManagementDTO> findAllMembers() {
		// TODO Auto-generated method stub
		return memberRepository.findAllMembers();
	}

	@Override
	public void deleteMember(Long memberId) {
		// TODO Auto-generated method stub
		memberRepository.deleteMember(memberId);
	}

	@Override
	public void updateMemberStatus(Long memberId, String status) {
		// TODO Auto-generated method stub
		memberRepository.updateMemberStatus(memberId, status);
	}

	@Override
	public int countById(String id) {
		// TODO Auto-generated method stub
		return memberRepository.countById(id);
	}

	@Override
	public int countByEmail(String email) {
		// TODO Auto-generated method stub
		return memberRepository.countByEmail(email);
	}
	
}
