package com.tg.test;

import java.util.ArrayList;

import com.tg.service.ScoreManager;
import com.tg.student.StudentVo;
import com.tg.subject.Subject;

public class SchoolManagerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Subject subjectObj = new Subject("국어", 50);
		Subject subjectObj2 = new Subject("영어", 80);
		
		ArrayList subjectList = new ArrayList();
		
		subjectList.add(subjectObj);
		subjectList.add(subjectObj2);
		
		System.out.println(subjectList);
		
		StudentVo studentVo = new StudentVo(1, "정의광");
		
		System.out.println(studentVo);
		
		ScoreManager scoreManager = new ScoreManager();
		
		scoreManager.studentInfo(studentVo, subjectList);
				
		// 학생
		studentVo = new StudentVo(2, "박성욱");
		// 과목
		subjectObj = new Subject("국어", 60);
		subjectObj2 = new Subject("영어", 70);
		
		subjectList = new ArrayList();
		subjectList.add(subjectObj);
		subjectList.add(subjectObj2);
		
		
		// 정보
		scoreManager.studentInfo(studentVo, subjectList);
		
	}

}
