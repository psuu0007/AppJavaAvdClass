package com.edu.member.dao;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<MemberDto> memberSelectList() {
		// TODO Auto-generated method stub
		List<MemberDto> memberList = 
				sqlSession.selectList("com.edu.member.memberSelectList");
		
		return memberList;
	}

	// 사용자 존재 유무 확인
	@Override
	public MemberDto memberExist(String email, String password) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		paramMap.put("pwd", password);
		
		MemberDto memberDto = 
			sqlSession.selectOne("com.edu.member.memberExist", paramMap);
		
		return memberDto;
	}

	@Override
	public void memberInsertOne(MemberDto memberDto) {
		// TODO Auto-generated method stub
		
		sqlSession.insert("com.edu.member.memberInsertOne", memberDto);
=======
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<MemberDto> memberSelectList() {
		// TODO Auto-generated method stub
		List<MemberDto> memberList = 
				sqlSession.selectList("com.edu.member.memberSelectList");
		
		return memberList;
>>>>>>> branch 'master' of https://github.com/psuu0007/AppJavaAvdClass.git
	}

}
