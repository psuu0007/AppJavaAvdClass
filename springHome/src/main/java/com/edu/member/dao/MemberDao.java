package com.edu.member.dao;

import java.util.List;

import com.edu.member.model.MemberDto;

public interface MemberDao {

	public List<MemberDto> memberSelectList();
<<<<<<< HEAD

	public MemberDto memberExist(String email, String password);
	
	public void memberInsertOne(MemberDto memberDto);
=======
	
>>>>>>> branch 'master' of https://github.com/psuu0007/AppJavaAvdClass.git
}
