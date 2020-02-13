
/**
 * 
 * @author TJ
 * 1부터 10까지 더하는 프로그램을 작성하시오
 * 
 * ========================
 * 1부터 10까지의 합: 55
 * for문
 */
public class ForTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		누적
//		1~10 까지의 합
		int sum = 0;
		
		int cnt = 1;
//		
//		        결과에 대한 자신 = 결과에 대한 자신 + 대상
//		몇 번? 횟수
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + "번째:\t" + sum + " + " + i + " = ");
			sum = sum + i;
			System.out.println(sum);
		}
		
		System.out.println("총합: " + sum);
		
//		sum = cnt + cnt + cnt;
//		System.out.println(sum);
	}

}
