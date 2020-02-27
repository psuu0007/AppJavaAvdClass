package com.tg.check;

//class 는 extends   => 상속한다 => 일반화  
//interface는 implements => 구현한다 => 실체화
public class FireTruck implements Car{

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
