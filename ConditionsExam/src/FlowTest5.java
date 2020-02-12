import java.util.Scanner;

/**
 * 
 * @author TJ 
 * 성적 처리 프로그램 
 * 90점 이상이면 A학점 
 * 80점 이상이면 B학점 
 * 70점 이상이면 C학점 
 * 그외는 F학점
 *         if문 사용 사용자 입력을 점수로 받는다 
 *         =========================== 
 *         당신의 점수는 70 학점은
 *         C입니다.
 * 
 */
public class FlowTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		System.out.print("점수를 입력하세요: ");
		int scoreNum = scan.nextInt();
		String grade;

		System.out.println("당신의 점수는 " + scoreNum);

		if (scoreNum >= 90) {
			grade = "A";
		} else if (scoreNum >= 80) {
			grade = "B";
		} else if (scoreNum >= 70) {
			grade = "C";
		} else {
			grade = "F";
		}

		System.out.println("학점은 " + grade + "입니다.");

	}

}
