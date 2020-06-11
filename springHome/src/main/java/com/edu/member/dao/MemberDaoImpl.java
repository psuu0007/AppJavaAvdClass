package com.edu.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.model.MemberDto;
import com.edu.member.model.MemberFileDto;


@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.member.";
	
	@Override
	public List<MemberFileDto> memberSelectList(String searchOption, 
			String keyword, int start, int end) {
	
		Map<String, Object> map = new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		
		List<MemberFileDto> memberList = 
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
	public int memberUpdateOne(MemberDto memberDto) {
		// TODO Auto-generated method stub
		
		return sqlSession.update(namespace + "memberUpdateOne"
				, memberDto);
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

	@Override
	public void insertFile(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + "insertFile", map);
	}

	
	@Override
	public List<Map<String, Object>> fileSelectList(int no) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(namespace + "fileSelectList", no);
	}

	@Override
	public Map<String, Object> fileSelectStoredFileName(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace 
				+ "fileSelectStoredFileName", no);
	}
	
	@Override
	public int fileDelete(int parentSeq) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "fileDelete", parentSeq);
	}

}
