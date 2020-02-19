
public class FirstClass3 {

	void firstMethod() {
		System.out.println("firstMethod() 시작");
		secondMethod();
		thirdMethod();
		System.out.println("firstMethod() 끝");
	}
	
	void secondMethod() {
		System.out.println("secondMethod() 시작");
		thirdMethod();
		System.out.println("secondMethod() 종료");
	}
	
	void thirdMethod() {
		System.out.println("thirdMethod() 시작");
		System.out.println("thirdMethod() 종료");
	}
	
}
