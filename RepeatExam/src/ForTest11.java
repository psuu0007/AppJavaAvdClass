/**
 * 
 * @author TJ
 
 */
public class ForTest11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "";
		int mulNum = 0;
//		
//		for (int dan = 2; dan <= 9; dan++) {
//			for (int n = 1; n <= 9; n++) {
//				mulNum = dan * n;
//				str = dan + " * " + n + " = " + mulNum + "\t";  
//				System.out.print(str);
//			}
//			System.out.println();
//		}
		
		int dan = 0;
//		int n = 0;
		dan = 2;
//		n = 1;
		while (dan <= 9) {
			int n = 1;
			while (n <= 9) {
				mulNum = dan * n;
				str = dan + " * " + n + " = " + mulNum + "\t";  
				System.out.print(str);
				n++;
			}
			n = 1;
			System.out.println();
			dan++;
		}
		
	}

}
