
//계산기를 만드시오
//+
///  정도만 만들면 됨
//사용자가 숫자를 입력한다
//오버로딩 사용하자
//5, 5.0
//
//add (int, double)수행 - 10.0
//divide (int, double) 수행 - 1.0

public class Calc {

//	int add(int n, int n2) {
//		System.out.println("int add(int n, int n2)");
//		return n + n2;
//	}

//	long add(int n, long n2) {
//		System.out.println("long add(int n, long n2)");
//		return n + n2;
//	}
//
	long add(long n, int n2) {
		System.out.println("long add(long n, int n2)");
		return n + n2;
	}
//	
	long add(long n, long n2) {
		System.out.println("long add(long n, long n2)");
		return n + n2;
	}
	
	double add(double d, double d2) {
		System.out.println("double add(double d, double d2)");
		return d + d2;
	}
	
	void add(int[] numArr) {
		int sum = 0;
		
		for (int i = 0; i < numArr.length; i++) {
			sum = sum + numArr[i];
		}
		System.out.println("void add(int[] numArr) 결과");
		System.out.println(sum);
	}

}
