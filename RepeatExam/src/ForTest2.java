/**
 * 
 * @author TJ
 * 1부터 10까지 더하는 프로그램을 작성하시오
 * 
 * 10까지의 합 : 55
 */
public class ForTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


//		누적 
		int sum = 0;
//		횟수
		int cnt = 0;
		
		for(int i = 5; i <= 10; i++) {
			sum += i;
			cnt++;
		}
		
		System.out.println(cnt + "까지의 합:" + sum);
					

	}

}
