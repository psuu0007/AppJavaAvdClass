package com.tg.check;

//참조형을 체크한다
public class TypeCheckTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		FireTruck f = new FireTruck();
		
		if(f instanceof Car) {
			System.out.println("f는 Car를 구현했다");
		}
		
		if(f instanceof FireTruck) {
			System.out.println("f는 FireTruck을 구현했다");
		}
		
//		if(f instanceof Ambulance) {
//			System.out.println("f는 Ambulance를 구현했다");
//		}
		
		if(f instanceof Object) {
			System.out.println("f는 Object클래스의 자식이다");
		}
		
	}

}
