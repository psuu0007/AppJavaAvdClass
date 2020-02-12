import java.util.Scanner;

public class OperatorEx12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 사용자가 입력할 변수
		int userInput = 0;
		// 임시 결과
		int tempNum = 0;
		// 사용자가 입혁한 값에 대한 홀짝 결과
		String result = "";
		String userName = "";
		
		// 키보드 입력
		Scanner scan = new Scanner(System.in);

		System.out.println("홀짝 판별 프로그램 시작");
		
		System.out.println("고객님 성함을 알려주세요");
		userName = scan.nextLine();
		System.out.println(userName + "님 원하시는 숫자를 입력해주세요");
		userInput = scan.nextInt();
		
		// 판별을 위한 과정 0 OR 1만 온다 
		tempNum = userInput % 2;
//		1 % 2;  1 / 2 = 0 1
//		2 % 2;  2 / 2 = 1 0
//		3 % 2;  3 / 2 = 1 1
//		4 % 2;  4 / 2 = 2 0
			
//		1 0 치자 
//		홀 짝
		// 사용자가 입력한 값에 대한 홀짝 판별결과
		// 홀짝 판별 결과 false 이면 짝, true이면 홀
		result = (tempNum == 0) ? "짝": "홀";
		
		System.out.println(result);
		System.out.println(userName + "님이 입력하신 값은 " + userInput);
		
	}

}
