
public class ArrayEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		정렬된 숫자를 랜덤하게 섞는 프로그램
		
		int[] numberArr = new int[10];
		
		for (int i = 0; i < 10; i++) {
			numberArr[i] = i;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.print(numberArr[i] + "  ");
		}
		System.out.println();

		int rndIndex = 0;
		int tempNum = 0;
		for (int i = 0; i < 10; i++) {
			rndIndex = (int)(Math.random() * 10);
			
			tempNum = numberArr[0];
			numberArr[0] = numberArr[rndIndex];
			numberArr[rndIndex] = tempNum;
		}
		
		for (int i = 0; i < 10; i++) {
			if(i == 9) {
				System.out.print(numberArr[i]);
				break;
			}
			System.out.print(numberArr[i] + ", ");
		}
	}

}
