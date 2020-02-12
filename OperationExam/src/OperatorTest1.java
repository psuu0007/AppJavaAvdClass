
public class OperatorTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		올림처리
		float pi = 3.145592f;

		// 소수점 2째자리까지 표현 3번째 자리에서 올림처리

		float shortPi = (int) (pi * 100 + 0.9) / 100f;

//		314.1 592;
//		3141;   / 1000.0f;
//		3.141f

		System.out.println(shortPi);
		
		
		
	}

}
