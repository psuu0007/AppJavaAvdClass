package com.tg.tryy;

public class ExceptionEx5 {
	
	public static void main(String[] args) {
		
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/4);    // 0으로 나누어서는 안된다
			System.out.println(4);
		}catch (ArithmeticException ae) {
			System.out.println("ArithmeticException");
		}finally {
			System.out.println(6);
		}
//		catch(Exception e) {
//			System.out.println("Exception");
//		}
		System.out.println(7);
		
		
	}
}
