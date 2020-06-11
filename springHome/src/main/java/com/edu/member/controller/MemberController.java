package com.edu.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.model.MemberDto;
import com.edu.member.model.MemberFileDto;
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
	
	@RequestMapping(value = "/member/list.do"
			, method = {RequestMethod.GET, RequestMethod.POST})
	public String MemberList(@RequestParam(defaultValue = "1") 
			int curPage
			, @RequestParam(defaultValue = "0") int no
			, @RequestParam(defaultValue = "all") String searchOption
			, @RequestParam(defaultValue = "") String keyword
			, Model model) {
		log.info("Welcome MemberList! " + curPage + " : ???? " 
			+ searchOption + " : " + keyword);
		
		// 화면의 form의 이름을 마바티스에 편하게 맞추기 위한 로직
		if("name".equals(searchOption)) {
			searchOption = "mname";
		}
		
		// 페이징을 위한 전체 회원목록 갯수
		int totalCount = 
			memberService.memberSelectTotalCount(
					searchOption, keyword
		);
		
		// 이전 페이지로 회원의 번호가 명확하게 나온 경우
		// 자신의 curPage 찾는 로직 
		if(no != 0) {
			curPage 
				= memberService.memberSelectCurPage(
						searchOption, keyword, no);
		}
		
//		
//		System.out.println("????????: " + curPage);
		
		Paging memberPaging = new Paging(totalCount, curPage);
		int start = memberPaging.getPageBegin();
		int end = memberPaging.getPageEnd();

		List<MemberFileDto> memberList = 
			memberService.memberSelectList(searchOption, keyword
				, start, end);

		// 화면의 form의 이름을 맞추기 위한 작업
		if("mname".equals(searchOption)) {
			searchOption = "name";
		}
		
		// 검색
		HashMap<String, Object> searchMap 
			= new HashMap<String, Object>();
		searchMap.put("searchOption", searchOption);
		searchMap.put("keyword", keyword);
		
		// 페이징
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("totalCount", totalCount);
		pagingMap.put("memberPaging", memberPaging);

		model.addAttribute("memberList", memberList);
		model.addAttribute("pagingMap", pagingMap);
		model.addAttribute("searchMap", searchMap);
		
		return "member/MemberListView";
	}
	
	@RequestMapping(value = "/member/listOne.do"
		, method = RequestMethod.GET)
	public String memberListOne(int no, String searchOption,
			String keyword, Model model) {
		log.info("call memberListOne! - " + no + "\n" + searchOption
				+ "\n" + keyword);
		
		Map<String, Object> map = memberService.memberSelectOne(no);
		
		MemberDto memberDto = (MemberDto)map.get("memberDto");
		
		List<Map<String, Object>> fileList = 
			(List<Map<String, Object>>)map.get("fileList");
		
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("fileList", fileList);
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyword", keyword);
		
		return "member/memberListOneView";
	}
	
	// 회원 추가 화면으로
	@RequestMapping(value = "/member/add.do")
	public String memberAdd(Model model) {
		
		log.info("call memberAdd!");
		
		return "member/MemberForm";
	}
	
	@RequestMapping(value = "/member/addCtr.do"
		, method = {RequestMethod.GET, RequestMethod.POST})
	public String memberAdd(MemberDto memberDto
		, MultipartHttpServletRequest mulRequest
		, Model model) {
		log.info("call memberAdd_ctr! {}", memberDto);
		
		memberService.memberInsertOne(memberDto, mulRequest);
		
		return "redirect:/member/list.do";
	} 
	
	// 회원 수정 화면으로
	@RequestMapping(value = "/member/update.do", method = RequestMethod.GET)
	public String memberUpdate(int no, Model model) {
		log.info("call memberUpdate! {}", no);
		
		Map<String, Object> map = memberService.memberSelectOne(no);
		
		MemberDto memberDto = (MemberDto)map.get("memberDto");
		
		List<Map<String, Object>> fileList = 
			(List<Map<String, Object>>)map.get("fileList");
		
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("fileList", fileList);
		
		return "member/MemberUpdateForm";
	}
	
	
	
	
	// 회원수정
	@RequestMapping(value = "/member/updateCtr.do"
			, method = RequestMethod.POST)
	public String memberUpdateCtr(HttpSession session, 
			MemberDto memberDto
			, @RequestParam(value="fileIdx"
				, defaultValue = "-1") int fileIdx
			, MultipartHttpServletRequest multipartHttpServletRequest
			, Model model) {
		log.info("call memberUpdateCtr! {} :: {}", memberDto, fileIdx);
		
		int resultNum = 0;
		
		try {
			// 설명하자
			resultNum = memberService.memberUpdateOne(memberDto
					, multipartHttpServletRequest, fileIdx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 데이터베이스에서 회원정보가 수정이 됬는데 세션에 있는 사람의 정보가 변경되었을 때
		// 처리 로직
		if(resultNum != 0) {
			MemberDto sessionMemberDto 
				= (MemberDto)session.getAttribute("member");
			
			if(sessionMemberDto != null) {
				
				if(sessionMemberDto.getNo() == memberDto.getNo()) {
					MemberDto newMemberDto = 
						new MemberDto(memberDto.getNo()
								, memberDto.getName()
								, memberDto.getEmail());
					
					session.removeAttribute("member");
					
					session.setAttribute("member", newMemberDto);
				}
				
			}
		}
		
		return "common/successPage";
	}
	
	// 회원삭제
	@RequestMapping(value = "/member/deleteCtr.do"
			, method = RequestMethod.GET)
	public String memberDeleteCtr(int no, Model model) {
		log.info("call memberDeleteCtr! " + no);
		
//		Map<String, Object> tempFileMap = null; 
//		tempFileMap = memberService.fileSelectStoredFileName(no);
		
		memberService.memberDeleteOne(no);
		
		return "redirect:/member/list.do";
	}
	
		
}
