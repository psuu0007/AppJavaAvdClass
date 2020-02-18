//7일차 17.02.18 (화)
/**
 * 국영수 3과목에 대해  5명의 성적이 있다
 * 각 총점과 평점을 구하고
 * 가장 높은 학생의 번호를 출력하시오
 * ======================
 *    국어 영어 수학
 * 1. 100 100 100
 * 2. 20  20  20
 * 3. 30  30  30
 * 4. 40  40  40
 * 5. 50  50  50
 * 
 * 수석 학생 : 1번 학생
 * 총점 : 300
 * 평균 : 100
 * 
 */
public class ArrayTest7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] scoreArr = new int[5][3];
		
		int sumArr[] = new int[5];
		int sum = 0;
		int max = 0;
		int posit = 0;
		double aver = 0.0;

		System.out.println("\t국어\t영어\t수학");
		//값 넣는곳
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0) {
					scoreArr[i][j] = (i+1) * 100;
				} else {
					scoreArr[i][j] = (i+1) * 10;
				}
			}
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + ".\t");
			for (int j = 0; j < 3; j++) {
				System.out.print(scoreArr[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		//합계 구하는곳
		for (int i = 0; i < 5; i++) {
			sum = 0;
			for (int n = 0; n < 3; n++) {
				sum = sum + scoreArr[i][n];
			}	
			sumArr[i] = sum;
			//System.out.println(sumArr[i]);
		}



		for (int i = 0; i < 4; i++) {
			if (sumArr[i] > sumArr[i+1]) {
				max = sumArr[i];
				posit = i + 1;
			}
			//System.out.println(max + posit);
		}
		//max = 257;
		
		System.out.println("\t국어\t영어\t수학\t총점");
		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + ".\t");
			for (int j = 0; j < 3; j++) {
				System.out.print(scoreArr[i][j] + "\t");
			}
			System.out.print(sumArr[i]);
			System.out.println();
		}

		//평균 구하는곳
		aver = (int)((double)max / 3 * 10) / 10.0;

		System.out.println("수석학생 : " + posit + " 번 학생");
		System.out.println("총점 : " + max);
		System.out.println("평균 : " + aver);
	}
}
