package com.tg.tryy;

public class ExceptionEx7 {
	
	public static void main(String[] args) {
//		예외 발생시키기
		
		try {
			Exception e = new Exception("고의로 발생시킴");
			throw e;
		} catch (Exception e) {
			System.out.println("에러 메시지: " + 
					e.getMessage());
			e.printStackTrace();
		}
//		IndexOutOfBoundsException a = new IndexOutOfBoundsException("이야");
//		throw a;
		System.out.println("프로그램 정상 종료됨");
		
	}
}
