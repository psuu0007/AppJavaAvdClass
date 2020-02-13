public class ForEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		2 * 1 = 2 2 * 2 = 4 2 * 3 = 6 ,,,,, 2 * 8 = 16 2 * 9 = 18
//		3 * 1 = 3 3 * 2 = 6 3 * 3 = 9 ,,,,, 3 * 8 = 27 3 * 9 = 27
//		;;;;;;;;;;;;;;
//		8 * 1 = 8 8 * 2 = 16 ;;;;;;;;;;;;;;;;;;;;;;;;  8 * 9 = 72
//		9 * 1 = 9 9 * 2 = 18 ;;;;;;;;;;;;       9 * 8 = 72 9 * 9 = 81 
//		
		String str = "";
		int mulNum = 0;
		
		for (int i = 2; i <= 9; i++) {
			for (int n = 1; n <= 9; n++) {
				mulNum = i * n;
				str = i + " * " + n + " = " + mulNum + "\t";  
				System.out.print(str);
			}
			System.out.println();
		}
		
		
	}

}
