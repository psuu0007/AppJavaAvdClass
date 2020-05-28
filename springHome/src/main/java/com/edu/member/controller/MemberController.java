package com.edu.member.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.member.model.MemberDto;
import com.edu.member.service.MemberService;

@Controller
public class MemberController {

	private static final Logger log = 
		LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(HttpSession session, Model model) {
		log.info("Welcome login!");
		
		
		return "auth/LoginForm";
	}
	
	@RequestMapping(value = "/loginCtr.do", method = RequestMethod.POST)
	public String loginCtr(String email, String password,
			HttpSession session, Model model) {
		log.info("Welcome loginCtr! " + email + ", " + password);
		
		String viewUrl = "";
		
		MemberDto memberDto = memberService.memberExist(email, password);
		
		if(memberDto != null) {
			session.setAttribute("member", memberDto);
			
			viewUrl = "redirect:/member/list.do";
		}else {
			viewUrl = "/auth/LoginFail";
		}
		
		return viewUrl;
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		log.info("Welcome logout!");

		session.invalidate();
		
		return "redirect:/login.do";
	}
	
	@RequestMapping(value = "/member/list.do", method = RequestMethod.GET)
	public String MemberList(Model model) {
		log.info("Welcome MemberList!");
		
		List<MemberDto> memberList = memberService.memberSelectList();

		model.addAttribute("memberList", memberList);
		
		return "member/MemberListView";
	}
	
	// 회원 추가 화면으로
	@RequestMapping(value = "/member/add.do")
	public String memberAdd(Model model) {
		
		log.info("call memberAdd!");
		
		return "member/MemberForm";
	}
	
 
	@RequestMapping(value = "/member/addCtr.do", method = RequestMethod.POST)
	public String memberAdd(MemberDto memberDto, Model model) {
		log.info("call memberAdd_ctr! {}", memberDto);
		
		memberService.memberInsertOne(memberDto);
		
		return "redirect:/member/list.do";
	} 
	
}
