
/**
 * 
 * @author TJ
 * 로또 번호 생성기
 */
// 배열
//관련있는 것들의 묶음
public class ArrayEx9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//		45공
		int[] ballArr = new int[45];
		
//		1~45 가지의 숫자 저장
		for (int i = 0; i < ballArr.length; i++) {
			ballArr[i] = i + 1;
		}
		
		for (int i = 0; i < 45; i++) {
			System.out.print(ballArr[i] + " ");
			if((i+1) % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
		
		int tempNum = 0; // 두 값을 바꾸는데 사용할 임시 변수
		int n = 0; // 임의의 값을 얻기위한 인덱스
		
		for (int i = 0; i < ballArr.length; i++) {
			n = (int)(Math.random() * 45); // 배열 범위(0~44)의 값을 얻는다
			
			// 뒤섞기
			tempNum = ballArr[0];
			ballArr[0] = ballArr[n];
			ballArr[n] = tempNum;
		}
		
		// 6개 출력
		for (int i = 0; i < ballArr.length; i++) {
			System.out.print(ballArr[i] + " ");
			if((i+1) % 10 == 0) {
				System.out.println();
			}
		}
		
	} // main
	

}
