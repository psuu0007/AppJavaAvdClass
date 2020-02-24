public class OddEven {

	// 홀짝판별 메서드
	void oddEvenCheck(int inputNum) {
		
		String oddEvenStr = "";
		if (inputNum % 2 == 0) {
			oddEvenStr = "짝";
		} else {
			oddEvenStr = "홀";
		}
		
		System.out.println("결과: " + oddEvenStr +  " 입니다.");
		System.out.println();
		
	}
	
}
