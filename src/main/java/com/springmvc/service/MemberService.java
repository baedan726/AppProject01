package com.springmvc.service;

import java.util.List;

import com.springmvc.dto.FindIdDTO;
import com.springmvc.dto.FindPwDTO;
import com.springmvc.dto.LoginDTO;
import com.springmvc.dto.LoginMemberDTO;
import com.springmvc.dto.MemberManagementDTO;
import com.springmvc.dto.MemberUpdateDTO;
import com.springmvc.dto.PwChangeDTO;
import com.springmvc.dto.SignupDTO;

public interface MemberService {
	LoginMemberDTO login(LoginDTO loginDTO);

    void signup(SignupDTO signupDTO);

    String findId(FindIdDTO findIdDTO);

    int findPw(FindPwDTO findPwDTO);

    void changePassword(Long memberId, PwChangeDTO pwChangeDTO);

    MemberManagementDTO findByMemberId(Long memberId);

    void updateMember(Long memberId, MemberUpdateDTO memberUpdateDTO);

    List<MemberManagementDTO> findAllMembers();

    void deleteMember(Long memberId);

    void updateMemberStatus(Long memberId, String status);

    int countById(String id);

    int countByEmail(String email);
}
