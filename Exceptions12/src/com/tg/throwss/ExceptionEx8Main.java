package com.tg.throwss;

public class ExceptionEx8Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test1 test1 = new Test1();
		
//		test1.method2();
		
		try {
			int num = test1.method2();
			System.out.println("dfsdf");
			System.out.println(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("예외 처리됨");
		}
		
		System.out.println("종료됨");
	}

}
