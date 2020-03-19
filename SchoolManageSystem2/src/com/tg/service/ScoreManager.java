package com.tg.service;

import java.util.ArrayList;

import com.tg.student.StudentVo;
import com.tg.subject.Subject;

public class ScoreManager {

//	총점을 구하는 서비스
	public void studentInfo(StudentVo studentVo, ArrayList subjectList) {
		String studentInfoStr = "";
		
		int sum = 0;
		for (int i = 0; i < subjectList.size(); i++) {
			sum = sum + ((Subject) subjectList.get(i)).getScore();
		}
		
		studentInfoStr += "====학생정보====\n";
		studentInfoStr += "번호: " + studentVo.getNo()+"\n";
		studentInfoStr += "이름: " + studentVo.getName()+"\n";
		
		System.out.println(); 
		
		for (int i = 0; i < subjectList.size(); i++) {
			studentInfoStr += ((Subject) subjectList.get(i)).getName() 
					+ "성적: ";
			studentInfoStr += ((Subject) subjectList.get(i)).getScore();
			studentInfoStr += "\n";
		}
		
		studentInfoStr += "총점: " + sum;
		
		System.out.println(studentInfoStr);
	}

	
	
}





