package com.tg.polymorphism;

//참조변수의 형변환
//기본형 변수와 같이 참조변수도 형변환이 가능하다
//단, 서로 상속관계에 있는 클래스 사이에서만 가능하기 때문에
//자식타입의 참조변수를 부모타입의 참조변수로,
//부모타입의 참조변수를 자식타입의 참조변수로 형변환만 가능하다
public class CarTest {

	public static void main(String[] args) {
		
//		down casting
//		큰 그릇 -> 작은 그릇 ??? 형변환을 할려는 의지 표명 -> 명시적 형변환 : 형변환 생략불가
//		up casting
//		작은 그릇 -> 큰 그릇 ??? 모두 담을 수 있다 -> 묵시적 형변환 : 형변환 생략가능 
		
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe;
//		car.water();
		car.drive();
		
		fe2 = (FireEngine)car;
		fe2.water();
		
	}
	
}
