
// 버블 1단계
public class ArrayEx7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numArr = {15, 11, 1, 3, 8};
		
		System.out.println("초기값");
		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i] + "  ");
		}
		
		int cnt = 0;
		int tempNum = 0;
		
		for (int i = 0; i < numArr.length; i++) {
			for (int n = 0; n < numArr.length-1-i; n++) {
				cnt++;
				if(numArr[n] > numArr[n+1]) {
					tempNum = numArr[n];
					numArr[n] = numArr[n+1];
					numArr[n+1] = tempNum;
				} // if end
			} // n for end
		} // i for end
		
		System.out.println();
		System.out.println("총 수행 횟수: " + cnt);
		System.out.println("정렬 후");
		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i] + "  ");
		}
		
	} // main
	

}
