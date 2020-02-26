package com.tg.test;

public class Test2 {

	void method1() throws Exception{
		System.out.println
		("method1() 시작");
		try {
			method2();
		} catch (Exception e) {
			System.out.println("??");
		}
		System.out.println
		("method1() 끝");
	}

	void method2() throws Exception{
		// TODO Auto-generated method stub
		System.out.println
		("method2() 시작");
		throw new Exception();
	}
	
}
