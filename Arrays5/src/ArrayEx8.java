
// 버블 3단계
public class ArrayEx8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numArr = {15, 11, 1, 3, 8};
		
		System.out.println("초기값");
		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i] + "  ");
		}
		System.out.println();
		
		// 몇 번 돌았는지 체크
		int cnt = 0;
		// 자리 교환을 위한 변수
		int tempNum = 0;
		
		// 자리 변경 여부 체크
		boolean changed = false;
		
		for (int i = 0; i < numArr.length; i++) {
			changed = false; // 다시 수행하는 부분에 대한 초기화
			
			System.out.println((i+1) + "번째 수행값 :\t");
			for (int n = 0; n < numArr.length-1-i; n++) {
				cnt++;
				// 오름차순
				if(numArr[n] > numArr[n+1]) {
					tempNum = numArr[n];
					numArr[n] = numArr[n+1];
					numArr[n+1] = tempNum;
					
					changed = true; // 자리 바꿈이 발생했음
				} // if end
						
				// 배열 값들의 중간 정렬 결과 확인
				for (int j = 0; j < numArr.length; j++) {
					System.out.print(numArr[j] + "  ");
				}
				System.out.println();
				
			} // n for end
			
			if(changed == false) {
				break; // 자리 변경이 없으면 반복문을 벗어남
			}
			
		} // i for end
		
		// 마지막 정렬 결과
		System.out.println();
		System.out.println("총 수행 횟수: " + cnt);
		System.out.println("정렬 후");
		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i] + "  ");
		}
		
	} // main
	

}
