
public class LottoTest {
//  로또에서 6개의 1등 번호를 출력하시오
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 45개의 정수값을 저장하기 위한 배열 생성
		int[] ballArr = new int[45];
		
		// 배열의 각 요소에 1~45의 값을 저장한다
		for (int i = 0; i < ballArr.length; i++) {
			ballArr[i] = i + 1;
		}
		
		int temp = 0; // 두 값을 바꾸는데 사용할 임시변수
		int rndNum = 0; // 임의의 값을 얻어서 저장할 변수
		
		// 배열의 i번째 요소와 임의의 요소에 저장된 값을 서로 바꿔서 값을 섞는다
		for (int i = 0; i < 6; i++) {
			rndNum = (int)(Math.random() * 45); // 0~44 범위의 임의의 값을 얻는다
			
			temp = ballArr[i];
			ballArr[i] = ballArr[rndNum];
			ballArr[rndNum] = temp;
		}
		
//		for (int i = 0; i < ballArr.length; i++) {
//			System.out.print(ballArr[i] + "\t");
//		}
		
		for (int i = 0; i < 6; i++) {
			System.out.printf("ball[%d] = %d%n", i, ballArr[i]);
		}
		
		
		
	}

}
