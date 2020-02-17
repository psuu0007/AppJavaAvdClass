import java.util.Scanner;

/**
 * 
 * @author TJ
 * 사용자의 숫자를 입력 받는다
 * 순서는 국어, 영어, 수학이다.
 * 국영수 중에 점수가 제일 높은 순으로 출력해라
 * 단, 3과목의 점수는 배열 변수 하나에 담겨있다.
 *  
 * =================================
 * 점수 입력 값: 100, 81, 93
 * 점수 정렬한 값: 100, 93, 81
 */

public class ArrayTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0;
		int[] numArr = new int[3];
		
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < numArr.length; i++) {
			System.out.println("숫자를 입력해주세요");
			numArr[i] = scan.nextInt();
		}
		
//		numArr[1] = scan.nextInt();
//		numArr[2] = scan.nextInt();

		System.out.println("정렬 전");
		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i] + "\t");
		}
		
		// 정렬 하자
		// 기본 정렬
		System.out.println();
		int tempNum = 0;
		for (int i = 0; i < numArr.length; i++) {
			for (int n = 0; n < numArr.length; n++) {
				cnt++;
				System.out.println("횟수: " + cnt);
				System.out.println(numArr[i] + " : " + numArr[n]);
				if(numArr[i] < numArr[n]) {
					tempNum = numArr[i];
					numArr[i] = numArr[n];
					numArr[n] = tempNum;
				}
				// 한번 수행하면 어떻게 될까?
				
				for (int k = 0; k < numArr.length; k++) {
					System.out.print(numArr[k] + "\t");
				}
				System.out.println();
				System.out.println("================");
			} // 내부 for end
		} // 바깥 for end
		
		System.out.println();
		System.out.println("정렬 후");
		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i] + "\t");
		}

	}

}
