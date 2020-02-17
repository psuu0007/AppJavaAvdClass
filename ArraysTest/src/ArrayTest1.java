
/**
 * 
 * @author TJ
 * 1부터 5까지 숫자가 들어있는 배열을 만들고
 * 순차적으로 출력하시오
 * ====================
 * 배열[0] = 1
 * 배열[1] = 2
 * 배열[2] = 3
 * 배열[3] = 4
 * 배열[4] = 5
 * 
 */
public class ArrayTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] scoreArr = null; // 선언문  null기본값
		scoreArr = new int[5];
		
		scoreArr[0] = 1;
		scoreArr[1] = 2;
		scoreArr[2] = 3;
		scoreArr[3] = 4;
		scoreArr[4] = 5;
		
		System.out.println(scoreArr[0]);
		System.out.println(scoreArr[1]);
		System.out.println(scoreArr[2]);
		System.out.println(scoreArr[3]);
		System.out.println(scoreArr[4]);
		
	}

}
