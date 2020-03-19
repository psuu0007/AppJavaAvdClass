package com.tg.test;

import com.tg.service.ScoreManager;
import com.tg.student.StudentVo;
import com.tg.subject.EnglishL;
import com.tg.subject.KoreaL;

public class SchoolManagerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EnglishL englishL = new EnglishL("영어", 80);
		System.out.println(englishL);
		KoreaL koreaL = new KoreaL("국어", 90);
		System.out.println(koreaL);
		
		StudentVo studentVo = 
				new StudentVo(1, "원아름"
						, koreaL, englishL, null);
		System.out.println(studentVo);
		
		ScoreManager scoreManager = new ScoreManager();
		
		scoreManager.setScoreTotal(studentVo);
		
		scoreManager.studentInfo(studentVo);
		
		
	}

}
