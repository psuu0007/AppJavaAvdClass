import java.util.Scanner;

/**
 * 
 * @author TJ
 */
public class ForTest12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int userSelectNum = 0;
		int answer = 0;
		// false라면 재시도, true라면 성공
		boolean check = false;
		
		Scanner scan = new Scanner(System.in);
		
		answer = (int)(Math.random() * 100) + 1;
		
		System.out.println("상대방이 숫자를 선택했습니다");
		System.out.println("1~100사이니 맞춰보세요");

		check = true;
		while (check) {
			System.out.print("1과 100사이의 정수를 입력하세요.>\t");
			userSelectNum = scan.nextInt();
			
			if(userSelectNum > answer) {
				System.out.println("더 작은 수로 다시 시도해주세요");
			}else if(userSelectNum < answer) {
				System.out.println("더 큰 수로 다시 시도해주세요");
			}else if(userSelectNum == answer){
				check = false;
			}
		}
		
		System.out.println("정답입니다");
		
		
		
		
	}

}
