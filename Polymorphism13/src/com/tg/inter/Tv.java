package com.tg.inter;
//
//인터페이스?
//인터페이스는 일종의 추상클래스이다 인터페이스는 추상클래스처럼 추상메서드를 갖지만
//추상클래스보다 추상화 정도가 높아서 추상클래스와 달리 몸통을 갖춘 일반 메서드 또는 
//멤버변수를 구성원으로 가질 수 없다, 
//오직 추상메서드와 상수만을 멤버로 가질 수 있으며, 그 외의 다른 어떠한 요소도 허용하지 않는다
//
//추상클래스를 부분적으로만 완성된 '미완성 설계도'라고 한다면,
//인터페이스는 구현된 것은 아무것도 없고 밑그림만 그려져 있는 '기본 설계도'라고 할 수 있다
//인터페이스도 추상클래스 처럼 완성되지 않은 불완전한 것이기 때문에
//그 자체만으로 사용되기 보다는 다른 클래스를 작성하는데 도움을 줄 목적으로 작성된다
//	클래스를 작성하는 것과 동일
//	다만 키워드로 class 대신 interface를 사용한다는 것만 다르다
//	그리고 interface도 클래스와 같이 접근제어자로 public or default를 사용할 수 있다
//
//	표현식(expression)
//	interface 인터페이스이름{
//	public static final 타입 상수이름 = 값;
//	public abstract 반환타입 메서드이름(파라미터목록);
//}


public interface Tv {

	public static final int MAX_CHANNEL = 100;
	final int MAX_VOLUME = 10;
	static int DACHUNG = 2;
	
	int NUMBER = 1;
	
	public abstract int getMaxNumber();
	int getMaxVolume();
	
}
