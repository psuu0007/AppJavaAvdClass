package the.good.question;

public class GlobalLocalTest {
	
	public int instanceNum = 10;
	public static int globalNum = 20;
	
	public void numbering(){
		int localNum = 30;
		
		System.out.println("instanceNum = " + instanceNum);
		System.out.println("globalNum = " + globalNum);
		System.out.println("localNum = " + localNum);
	}
	
}
