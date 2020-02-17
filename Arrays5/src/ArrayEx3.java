
public class ArrayEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		최대값 찾기
		int[] scoreArr = {
				79, 88, 91, 33, 100,
				55, 95
		};
		
		int maxNum = scoreArr[0];
		int minNum = scoreArr[0];
		
		for (int i = 1; i < 7; i++) {
			if(maxNum < scoreArr[i]) {
				maxNum = scoreArr[i];
			}
			
			if(minNum > scoreArr[i]) {
				minNum = scoreArr[i];
			}
		}
		System.out.println("최대값: " + maxNum);
		System.out.println("최소값: " + minNum);		
		

	}

}
