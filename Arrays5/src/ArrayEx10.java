
/**
 * 
 * @author TJ
 * 
 * 
 */
public class ArrayEx10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numberArr = new int[5];
		int[] newNumArr = new int[5];
		
		for (int i = 0; i < newNumArr.length; i++) {
			numberArr[i] = i+1;
		}
		
//		newNumArr = numberArr;
		newNumArr[0] = numberArr[0];
		newNumArr[1] = numberArr[1];
		newNumArr[2] = numberArr[2];
		newNumArr[3] = numberArr[3];
		newNumArr[4] = numberArr[4];
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
		numberArr[3] = 23123;
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
		
	} // main
	

}
