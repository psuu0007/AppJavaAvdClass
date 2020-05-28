package com.edu.member.dao;

import java.util.List;

import com.edu.member.model.MemberDto;

public interface MemberDao {

	public List<MemberDto> memberSelectList();
	
}
