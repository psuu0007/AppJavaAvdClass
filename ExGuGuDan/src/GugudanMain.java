import java.util.Scanner;

public class GugudanMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int firstDan = 0;
		int secondDan = 0;
		
		System.out.println("첫 숫자를 입력해주세요");
		firstDan = scan.nextInt();
		
		System.out.println("두 번째 숫자를 입력해주세요");
		secondDan = scan.nextInt();
		
		Gugudan gugudan = new Gugudan();
		
		gugudan.multiGuGu(firstDan, secondDan);
		
	}
	
}
