package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.dto.LoginDTO;
import com.springmvc.dto.LoginMemberDTO;
import com.springmvc.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("loginDTO",new LoginDTO());
		return "member/login";
	}
	
	@PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO,
                        HttpSession session,
                        RedirectAttributes rttr) {

        LoginMemberDTO loginMember = memberService.login(loginDTO);

        if (loginMember == null) {
            rttr.addFlashAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "redirect:/member/login";
        }

        session.setAttribute("loginMember", loginMember);

        return "redirect:/";
    }
}
