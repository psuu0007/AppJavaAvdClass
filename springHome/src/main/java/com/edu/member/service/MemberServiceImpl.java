package com.edu.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.member.dao.MemberDao;
import com.edu.member.model.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	public MemberDao memberDao;
	
	@Override
	public List<MemberDto> memberSelectList() {
		// TODO Auto-generated method stub
		List<MemberDto> memberList = memberDao.memberSelectList();
		
		return memberList;
	}

<<<<<<< HEAD
	@Override
	public MemberDto memberExist(String email, String password) {
		// TODO Auto-generated method stub
		
		MemberDto memberDto = memberDao.memberExist(email, password);
		
		return memberDto;
	}

	@Override
	public void memberInsertOne(MemberDto memberDto) {
		// TODO Auto-generated method stub
		memberDao.memberInsertOne(memberDto);
	}
=======
	
>>>>>>> branch 'master' of https://github.com/psuu0007/AppJavaAvdClass.git
	
}
