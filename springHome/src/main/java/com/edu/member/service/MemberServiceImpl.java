package com.edu.member.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.member.dao.MemberDao;
import com.edu.member.model.MemberDto;
import com.edu.member.model.MemberFileDto;
import com.edu.util.FileUtils;

@Service
public class MemberServiceImpl implements MemberService{

	private static final Logger log = 
			LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	public MemberDao memberDao;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Override
	public List<MemberFileDto> memberSelectList(String searchOption, 
			String keyword, int start, int end) {
		// TODO Auto-generated method stub
		List<MemberFileDto> memberList = 
				memberDao.memberSelectList(searchOption, keyword
					, start, end);
		
		return memberList;
	}

	@Override
	public MemberDto memberExist(String email, String password) {
		// TODO Auto-generated method stub
		
		MemberDto memberDto = memberDao.memberExist(email, password);
		
		return memberDto;
	}

	@Override
	public void memberInsertOne(MemberDto memberDto
		, MultipartHttpServletRequest multipartHttpServletRequest) {
		
//		MultipartFile multipartFile 
//			= multipartHttpServletRequest.getFile("file");
//		
//		log.debug("---------- file start ----------");
//		log.debug("name: {}", multipartFile.getName());
//		log.debug("fileName: {}", multipartFile.getOriginalFilename());
//		log.debug("size: {}", multipartFile.getSize());
//		log.debug("---------- file end ----------\n");
//		
		memberDao.memberInsertOne(memberDto);
		
		
		int parentSeq = memberDto.getNo();
		
		try {
			List<Map<String, Object>> fileList = 
				fileUtils.parseInsertFileInfo(parentSeq
					, multipartHttpServletRequest);
			
			for (int i = 0; i < fileList.size(); i++) {
				memberDao.insertFile(fileList.get(i));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("문제 생기면 처리할꺼 정하자");
			System.out.println("일단 여긴 파일 처리 중 문제 발생한 거야");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Map<String, Object> memberSelectOne(int no) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		MemberDto memberDto = memberDao.memberSelectOne(no);
		
		resultMap.put("memberDto", memberDto);
		
		//
		List<Map<String, Object>> fileList = memberDao.fileSelectList(no);
		resultMap.put("fileList", fileList);
		
		return resultMap;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int memberUpdateOne(MemberDto memberDto
			, MultipartHttpServletRequest multipartHttpServletRequest
			, int fileIdx) throws Exception{
		// TODO Auto-generated method stub
		int resultNum = 0;
		
		try {
			int parentSeq = memberDto.getNo();
			Map<String, Object> tempFileMap 
				= memberDao.fileSelectStoredFileName(parentSeq);
			
			List<Map<String, Object>> list 
				= fileUtils.parseInsertFileInfo(parentSeq
						, multipartHttpServletRequest);
			
			// 오로지 하나만 관리 수정
			if(list.isEmpty() == false) {
				for (Map<String, Object> map : list) {
					memberDao.insertFile(map);
				}
				
				if(tempFileMap != null) {
					memberDao.fileDelete(parentSeq);
					fileUtils.parseUpdateFileInfo(tempFileMap);
				}
			}else if(fileIdx == -1) {
				if(tempFileMap != null) {
					memberDao.fileDelete(parentSeq);
					fileUtils.parseUpdateFileInfo(tempFileMap);
				}
			}
			
			resultNum = memberDao.memberUpdateOne(memberDto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			TransactionAspectSupport
				.currentTransactionStatus().setRollbackOnly();
		} 
		
		return resultNum;
	}

	@Override
	public int memberDeleteOne(int no) {
		// TODO Auto-generated method stub
		return memberDao.memberDeleteOne(no);
	}

	@Override
	public int memberSelectTotalCount(String searchOption
			, String keyword) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectTotalCount(searchOption
				, keyword);
	}

	@Override
	public Map<String, Object> fileSelectStoredFileName(int no) {
		// TODO Auto-generated method stub
		return memberDao.fileSelectStoredFileName(no);
	}

	@Override
	public int memberSelectCurPage(String searchOption
			, String keyword, int no) {
		// TODO Auto-generated method stub
		
		return memberDao.memberSelectCurPage(searchOption, keyword, no);
	}

	
}
