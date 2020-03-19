package com.tg.service;

import com.tg.student.StudentVo;

public class ScoreManager {

//	총점을 구하는 서비스
	public void studentInfo(StudentVo studentVo) {
		String studentInfoStr = "";
		
		studentInfoStr += "====학생정보====\n";
		studentInfoStr += "번호: " + studentVo.getNo()+"\n";
		studentInfoStr += "이름: " + studentVo.getName()+"\n";
		studentInfoStr += studentVo.getKoreaL().getName() + 
		 	"점수: " + studentVo.getKoreaL().getScore()+"\n";
		studentInfoStr += studentVo.getEnglishL().getName() + 
		 	"점수: " + studentVo.getEnglishL().getScore()+"\n";
		studentInfoStr += "총점: " + studentVo.getTotalScore();
		
		System.out.println(studentInfoStr);
	}

	public void setScoreTotal(StudentVo studentVo) {
		int totalScore = 0;
		
		totalScore = studentVo.getKoreaL().getScore() 
				+ studentVo.getEnglishL().getScore();
		
		studentVo.setTotalScore(totalScore);
	}
	
}
