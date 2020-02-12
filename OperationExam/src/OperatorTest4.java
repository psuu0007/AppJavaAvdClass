
public class OperatorTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5, k = 0;
		
		k = n++ + 1;
		System.out.println("k = n++ => n : " + n 
				+ " k : " + k);
		
		n = 5;
		k = 0;
		
		k = 1 + ++n;
		System.out.println("k = ++n => n :" + n
				+ " k: " + k);		
	}

}
