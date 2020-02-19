
public class Calculator2 {

//	메서드
//	표현식
//	리턴타입 메서드이름 (타입 변수명, 타입 변수명, ...) { <- 선언부
//		메서드 호출 시 수행될 코드   					<- 구현부
//	}
	
	
//	파라미터 parameter, 매개변수
	void add(int a, int b) {
		int sum = 0;
		sum = a + b;
		
		System.out.println(a + " + " + b + " = " + sum);
		
		sum = a * b;
		System.out.println(sum);
	}
	
	
}
