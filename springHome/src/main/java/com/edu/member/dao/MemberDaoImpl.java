package com.edu.member.dao;

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

}
