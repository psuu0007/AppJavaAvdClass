
public class OperatorTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		1인지 0인지 판단하는 프로그램
		
		// 판단할 변수
		int input = -1;
//		삼항연산자를 이용해서 
//		입력하신 값은 1
//		"전원을 켰습니다"		
		
//		입력하신 값은 0
//		"전원을 종료합니다"
		String result = "";
		
		input = 100;
//		result = (input == 1) ? "입력하신 값은 " + input + "\n전원을 켰습니다" 
//				: "입력하신 값은 " + input + "\n전원을 종료합니다";
//		result = (input == 1) ? "입력하신 값은 1\n전원을 켰습니다" 
//				: "입력하신 값은 0\n전원을 종료합니다";
		
//		다중 삼항연산자
		
		result = (input >= 1) ? "입력하신 값은 " + input + "\n전원을 켰습니다" 
				: (input == 0) ? "입력하신 값은 0\n전원을 종료합니다"
						: "입력하신 값은 " + input + "\n잘못입력했습니다";
		
		System.out.println(result);
		
	}

}
