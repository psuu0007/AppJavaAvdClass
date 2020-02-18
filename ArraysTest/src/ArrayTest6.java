/**
 * 
 * @author TJ
 * numberArr에 5, 4, 3, 2, 1를 넣는다
 * 이 값을 섞어서 출력한다
 * 단, 배열 변수를 하나더 생성한다.
 * ========================
 * 초기값: 5, 4, 3, 2, 1 (numberArr변수에 들어있는 값)
 * 셔플값: 1, 3, 5, 2, 4 (새로운 배열 변수에 들어있는 값)
 * 
 */
public class ArrayTest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numberArr = new int[5];
		int[] newNumArr = new int[5];
		
		for (int i = 0; i < newNumArr.length; i++) {
			numberArr[i] = i+1;
		}
		newNumArr = numberArr;
//		
		System.out.println("numberArr 출력");
		for (int i = 0; i < numberArr.length; i++) {
			System.out.println(numberArr[i]);
		}
		
		System.out.println("newNumArr 출력");
		for (int i = 0; i < newNumArr.length; i++) {
			System.out.println(newNumArr[i]);
		}
		
		newNumArr[0] = 10;
		numberArr[2] = 3000;
		System.out.println();
		System.out.println("원본은 지켜야한다");
		
		System.out.println("numberArr 출력");
		for (int i = 0; i < numberArr.length; i++) {
			System.out.println(numberArr[i]);
		}
		
		System.out.println("newNumArr 출력");
		for (int i = 0; i < newNumArr.length; i++) {
			System.out.println(newNumArr[i]);
		}
		

	}

}
