import java.util.Scanner;

public class HashCodeEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		문자열 비교 equals
		
		Scanner scan = new Scanner(System.in);
		String test = scan.nextLine();
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println("abc" == "abc");
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println("abc".hashCode()); // 상수풀
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}

}
