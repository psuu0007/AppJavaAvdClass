import java.util.Scanner;

public class ExamTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 홀짝 판별 프로그램

//		사용자로부터 숫자를 하나 입력을 받아서
		
//		2라면 짝
//		3이라면 홀이라고 출력한다
//출력 ex:
//		숫자를 하나 입력
//		2
//		입력하신 값은 2
//		결과: 짝 입니다.
		OddEven oddEven = new OddEven();
		int inputNum = 0; // 사용자로부터 받은 값

		Scanner scan = new Scanner(System.in);
//		
		System.out.println("숫자를 하나 입력");
		inputNum = scan.nextInt();

		System.out.println("입력하신 값은 " + inputNum);
		
		oddEven.oddEvenCheck(inputNum);
		
		System.out.println(); // 
		
		System.out.println("숫자를 하나 입력해주세요");
		inputNum = scan.nextInt();

		oddEven.oddEvenCheck(inputNum);

	}

}
