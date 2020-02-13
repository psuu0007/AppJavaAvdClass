/**
 * 
 * @author TJ
 *
 * 삼각형을 출력해라
 * =======================
   *
   **
   ***
   ****
   *****
 */
public class ForTest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "";
		str = "!";
		
		for (int i = 0; i < 5; i++) {
			for (int n = 0; n <= i; n++) {
				System.out.print("!");
			}
			System.out.println();
		}
		
		for (int i = 5; i > 0; i--) {
			for (int n = 0; n <= i; n++) {
				System.out.print("!");
			}
			System.out.println();
		}
		
		
//		System.out.print("*");
//		System.out.println();
//		
//		System.out.print("**");
//		System.out.println();
//		
//		System.out.print("***");
//		System.out.println();
//		
//		System.out.print("****");
		
	}

}
