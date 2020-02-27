package com.tg.check;

//인터페이스의 장점?
//		- 개발시간을 단축시킬 수 있다
//		  인터페이스를 구현하는 클래스가 작성될 때 가지 기다리지 않고도 양쪽에서 동시에
//		  개발이 가능하다
//		- 표준화가 가능하다
//		 일관되고 정형화된 프로그램의 개발이 가능하다
//		- 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다
//		   다형성
//		- 독립적인 프로그래밍이 가능하다
//		  한 클래스의 변경이 관련된 다른 클래스에 영향을 미치지 않는 
//		  독립적인  프로그래밍이 가능하다
public class Ambulance implements Car{

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("왜왜왜왱!");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("물대포!!!");
	}
	
}
