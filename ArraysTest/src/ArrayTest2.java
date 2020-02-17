/**
 * 
 * @author TJ
 * 100, 81, 100, 100, 93, 17
 * 81.83333333333.....
 * 총점과 평균을 구하시오. 
 * 평균은 소수점 3째자리에서 반올림하시오.
 * 총점	: 평균 
 * ??	: ???
 * 
 */

public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//		int[] scoreArr = new int[5];
		int[] scoreArr = {100, 81, 100, 100, 93, 17};
		int sum = 0;		// int / int =int
		double avg = 0;		// int / double = double
		
		for(int i=0; i<6; i++) {
			sum = sum + scoreArr[i];
		}
		
//		총점 / 6
//		정수 / 정수 => 정수
//		실수 = 정수 ? x
//		실수 = (double)81;
//		실수 = 81.0;
		avg = sum / 6;	// 81.0
		System.out.println(avg);
		//avg = 81.8399; 	//반올림될 경우
//		81.0 * 100
//		실수 * 정수 => 실수 * (double)정수
//		실수 * 실수 => 실수
//		81.0 * 100 => 81.0 * 100.0 => 8100.0;
//		System.out.println(avg * 100 + 0.5);
//		8100/100.0 => 정수 / 실수 => (double)정수 / 실수
//		실수 / 실수 => 8100.0 / 100.0 => 81.0		
//		avg = (int)(avg * 100 + 0.5) /100.0; 		//반올림을 위해 + 0.5	(ex 8183.x vs 8184.x)
		//변수랑 나누는거랑 float이든 double이든 맞춰야함.
//		System.out.println(avg);
		
//		총점 / 6
//		정수 / 정수 => 정수
//		avg = sum / 6d;	// 81.83333...
		//avg = 81.8399; 	//반올림될 경우
		//반올림을 위해 + 0.5	(ex 8183.x vs 8184.x)
//		avg = (int)(((sum / 6.0) * 100) + 0.5) / 100.0;
		
		avg = sum / 6.0; // 평균
		System.out.println(avg);
		avg = avg * 100; // 두자리 숫자까지 구할 로직 => 자릿수 올리기
		System.out.println(avg);
		avg = avg + 0.5; // 반올림 처리
		System.out.println(avg);
		avg = (int)avg;  // 실수부 버리기
		System.out.println(avg);
		avg = avg / 100.0; // 자릿수 되돌리기 => 소수점 셋째 자리에선 반올림 결과
		System.out.println(avg);
		
		//변수랑 나누는거랑 float이든 double이든 맞춰야함.
		
		System.out.println("총점\t:\t평균");
		System.out.println(sum+"\t:\t"+avg);
	}

}
