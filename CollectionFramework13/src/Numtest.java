import java.util.ArrayList;
import java.util.Scanner;

public class Numtest {

	public static void main(String[] args) {
		
		int mul = 0;
		
		ArrayList numArr = new ArrayList();
		
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		System.out.println("두수를 입력하시오");
		numArr.add(scan.nextInt());
		numArr.add(scan2.nextInt());
		mul = ((int)numArr.get(0) + (int)numArr.get(1));
		System.out.println("두수를 합한 값은?");
		System.out.println(mul);
		
		
		
	}
}
