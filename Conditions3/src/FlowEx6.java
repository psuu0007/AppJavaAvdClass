import java.util.Scanner;

public class FlowEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		다중 if문, 중첩 if문
		Scanner scan = new Scanner(System.in);

		System.out.print("점수를 입력하세요: ");
		int scoreNum = scan.nextInt();
		String grade;

		System.out.println("당신의 점수는 " + scoreNum);

		if (scoreNum >= 90) {
			grade = "A";
			if(scoreNum >= 98) {
				grade += "+"; 
			}
		} else if (scoreNum >= 80) {
			grade = "B";
			if(scoreNum >= 88) {
				grade += "+";
			}else if(scoreNum < 84) {
				grade = grade + "-";
			}
		} else if (scoreNum >= 70) {
			grade = "C";
		} else {
			grade = "F";
		}
		
		if(scoreNum >= 98) {
			grade = "A+"; 
		}else if (scoreNum >= 90) {
			grade = "A";
		}else if(scoreNum >= 88) {
			grade = "B+";
		}else if(scoreNum >= 83) {
			grade = "B-";
		}else if (scoreNum >= 80) {
			grade = "B";
		}

		System.out.println("학점은 " + grade + "입니다.");
				
		
	}

}
