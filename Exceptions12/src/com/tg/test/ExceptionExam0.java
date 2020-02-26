package com.tg.test;

public class ExceptionExam0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test2 test2 = new Test2();
		
		try {
			System.out.println("시작");
			test2.method1();
			System.out.println("끝");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("예외처리됨");
		}
		
	}

}
