package com.tg.tryy;

public class ExceptionEx1 {
//	예외처리(exception) - validation
//	
//	프로그램 오류?
//		프로그램이 실행 중 어떤 원인에 의해서 오작동을 하거나 비정상적으로 종료되는 
//		경우가 있다. 이러한 결과를 초래하는 원인을 프로그램 에러 또는 오류라고 한다
//		이를 발생시점에 따라 컴파일 에러와 런타임 에러로 나눌 수 있다
//	컴파일 에러(compile-time error)?
//			컴파일 할 때 발생하는 에러
//	런타임 에러(runtime error)?
//			프로그램의 실행도중 발생하는 에러
//	논리적 에러(logical error)?
//			컴파일도 잘 되고 실행도 잘 되지만 의도한 것과 다르게 동작하는 것
//	(컴파일을 에러없이 성공적으로 마쳤다고 해서 프로그램의 실행 시에도 에러가 발생하지
//			않는 것은 아니다)
//
//	자바에서는 실행 시 발생할 수 있는 프로그램 오류를 에러(error)와 예외(exception) 
//	두 가지로 구분하였다
//	에러?
//			프로그램 코드에 의해서 수습될 수 없는 심각한 오류
//	예외?
//			프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
//	목표: 프로그램의 비정상적인 종료를 막는다
	
//	try ~ catch문
	public static void main(String[] args) {

		int number = 100;
		int result = 0;
//		x / 0
		for (int i = 0; i < 10; i++) {
			try {
				result = number / (int) (Math.random() * 10);
				System.out.println(result);
			} catch (ArithmeticException e) {
				System.out.println("아하 이곳에 왔구나");
				System.out.println("0");
			}
		} // for 종료
	} 

}
