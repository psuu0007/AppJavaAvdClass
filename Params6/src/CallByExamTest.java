
public class CallByExamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 exam1 = new Exam1();
		Exam2 exam2 = new Exam2();
		Exam3 exam3 = new Exam3();
		
		int result = 0;
		int a = 0, b = 0;
		int[] cArr = new int[1];
		int[] dArr = new int[1];
		
		
		a = 10;
		b = 20;
		cArr[0] = 10;
		dArr[0] = 20;
		exam3.n = 10;
		exam3.m = 20;
		
		result = exam1.add(a, b);
		
		System.out.println(result);
		System.out.println("a= " + a + "/ b= " + b);
		
		System.out.println("=============");
		
		result = exam2.add(cArr, dArr);
		
		System.out.println(result);
		System.out.println("cArr= " + cArr[0] + "/ dArr= " + dArr[0]);
		
		System.out.println("=============");
		
		result = exam3.add(exam3);
		
		System.out.println(result);
		System.out.println("exam3.n= " + exam3.n + "/ exam3.m= " + exam3.m);
	}

}
