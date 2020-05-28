package com.edu.member.service;

import java.util.List;

import com.edu.member.model.MemberDto;

public interface MemberService {

	public List<MemberDto> memberSelectList(int start, int end);
	public MemberDto memberExist(String email, String password);
	public void memberInsertOne(MemberDto memberDto);
	public MemberDto memberSelectOne(int no);
	public void memberUpdateOne(MemberDto memberDto);
	public int memberDeleteOne(int no);
	
	public int memberSelectTotalCount();
}
