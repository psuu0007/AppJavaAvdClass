
public class OperatorEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		내림 처리
		float pi = 3.141592f;
		
		// 소수점 3째자리까지 표현
//		원본값 * 자릿수 / 되돌릴 자릿수 => 자릿수 내림
		float shortPi = (int)(pi * 1000) / 1000f;
		
//		3141.592;
//		3141;   / 1000.0f;
//		3.141f
		
		System.out.println(shortPi);
		
		
	}

}
