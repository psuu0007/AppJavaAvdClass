package com.edu.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.edu.util.Paging;

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
		
		int totalCount = memberService.memberSelectTotalCount();
		
		Paging memberPaging = new Paging(totalCount, 1);
		int start = memberPaging.getPageBegin();
		int end = memberPaging.getPageEnd();
		
		List<MemberDto> memberList = 
			memberService.memberSelectList(start, end);

		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("memberPaging", memberPaging);
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("pagingMap", pagingMap);
		
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
	
	// 회원 수정 화면으로
	@RequestMapping(value = "/member/update.do", method = RequestMethod.GET)
	public String memberUpdate(int no, Model model) {
		log.info("call memberUpdate! {}", no);
		
		MemberDto memberDto = memberService.memberSelectOne(no);
		
		model.addAttribute("memberDto", memberDto);
		
		return "member/MemberUpdateForm";
	}
	
	
	
	
	// 회원수정
	@RequestMapping(value = "/member/updateCtr.do"
			, method = RequestMethod.POST)
	public String memberUpdateCtr(MemberDto memberDto, Model model) {
		log.info("call memberUpdateCtr! " + memberDto);
		
		memberService.memberUpdateOne(memberDto);
		
		return "redirect:/member/list.do";
	}
	
	// 회원삭제
	@RequestMapping(value = "/member/deleteCtr.do"
			, method = RequestMethod.GET)
	public String memberDeleteCtr(int no, Model model) {
		log.info("call memberDeleteCtr! " + no);
		
		memberService.memberDeleteOne(no);
		
		return "redirect:/member/list.do";
	}
	
		
}
