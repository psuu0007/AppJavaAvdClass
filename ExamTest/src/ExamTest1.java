
public class ExamTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		총합
//		3개의 숫자를 더한 값을 출력한다
//		평균 소수점 1자리에서 반올림한다
		Calculator cal = new Calculator();
		int firstNum = 0;
		int secondNum = 0;
		int thirdNum = 0;
		
		int sum = 0;
		
		firstNum = 10;
		secondNum = 20;
		thirdNum = 30;
		
		sum = cal.totalValue(firstNum, secondNum, thirdNum);
		cal.totalPrint(sum);
		//
		cal.totalPrint(sum);
		
		firstNum = 20;
		secondNum = 30;
		thirdNum = 40;
		
		sum = cal.totalValue(firstNum, secondNum, thirdNum);
		cal.totalPrint(sum);
		
		
		
	}

}
