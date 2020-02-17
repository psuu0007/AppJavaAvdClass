/**
 * 
 * @author TJ
 * 최대값, 최소값을 구하라
 * 
 * ========================
 * 최대값: 100
 * 최소값: 33
 * 
 * 최대값의 위치는 5
 * 최소값의 위치는 4
 * 
 */

public class ArrayTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] scoreArr = {
				79, 88, 91, 33, 100,
				55, 95
		};
		
		int maxNum = 0;
		
		for (int i = 0; i < 7; i++) {
			if(maxNum < scoreArr[i]) {
				maxNum = scoreArr[i];
			}
		}
		
		System.out.println("최대값: " + maxNum);

	}

}
