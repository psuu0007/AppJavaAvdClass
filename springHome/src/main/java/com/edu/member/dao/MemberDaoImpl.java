package com.edu.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.member.";
	
	@Override
	public List<MemberDto> memberSelectList(int start, int end) {
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		List<MemberDto> memberList = 
				sqlSession.selectList(namespace + "memberSelectList"
				, map);
		
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
			sqlSession.selectOne(namespace + "memberExist", paramMap);
		
		return memberDto;
	}

	@Override
	public void memberInsertOne(MemberDto memberDto) {
		// TODO Auto-generated method stub
		
		sqlSession.insert(namespace + "memberInsertOne", memberDto);
	}

	@Override
	public MemberDto memberSelectOne(int no) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespace + "memberSelectOne"
				, no);
	}

	@Override
	public void memberUpdateOne(MemberDto memberDto) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + "memberUpdateOne", memberDto);
	}

	@Override
	public int memberDeleteOne(int no) {
		// TODO Auto-generated method stub
		
		return sqlSession.delete(namespace + "memberDeleteOne", no);
	}

	@Override
	public int memberSelectTotalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberSelectTotalCount");
	}

}
