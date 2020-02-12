import java.util.Scanner;

public class FlowEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		if else if문
//		expression(표현식)
//		
//		if(조건식1) {
//			조건식1의 연산결과가 true일 때 수행될 문장들을 적는다
//		}else if(조건식2){
//			조건식2의 연산결과가 true일 때 수행될 문장들을 적는다
//		}else if(조건식3) {
//			조건식3의 연산결과가 true일 때 수행될 문장들을 적는다
//		}else {
//			위의 어느 조건식도 만족하지 않을때 수행될 문장들을 적는다
//		}
		
		// 1이면 시작
		// 2이면 수행
		// 3이면 정지
		// 그 외는 종료
		int code = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("코드를 입력해주세요");
		System.out.println("1 시작\t 2 수행\t 3 정지\t 4 종료");
		code = scan.nextInt();
		
		if(code == 1) {
			System.out.println("시작");
		}else if(code == 2) {
			System.out.println("수행");
		}else if(code == 3) {
			System.out.println("정지");
		}else {
			System.out.println("종료");
		}
				
		
	}

}
