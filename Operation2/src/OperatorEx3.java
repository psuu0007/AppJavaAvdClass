
public class OperatorEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		사칙 연산자
//		모든 이항 연산자는 연산을 수행하기 전에
//		- 크기가 4byte이하인 자료형을 int형으로 변환한다
//		- 피연산자들의 타입을 서로 일치시킨다
//		
//		1.int형보다 크기가 작은 자료형은 int형으로 형변환 후에
//		연산을 수행한다
//		ex: byte + short -> int + int -> int
//		2.두 개의 피연산자 중 자료형의 표현번위가 큰 쪽에 맞춰서 형변환 된 후
//		연산을 수행한다
//		ex: int + float -> float + float -> float
//		3. 정수형 간의 나눗셈에서 0으로 나누는 것은 금지되어 있다 
		
//		System.out.println(45 / 5);
//		System.out.println(45 / 0);
		/*
		 * byte a = 10; byte b = 20;
		 * 
		 * byte sum = (byte)(a + b); System.out.println(sum);
		 */
		
		int a = 100000;
		int b = 200000;
		
		long multiply = (long)a * b;
		
		System.out.println(multiply);
		
		
		
		
	}

}
