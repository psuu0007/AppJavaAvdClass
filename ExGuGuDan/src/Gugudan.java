
public class Gugudan {

	void multiGuGu(int firstDan, int secondDan) {

		if(secondDan<firstDan) {
			System.out.println("잘못입력했습니다.");
		} 
		
		for (int i = firstDan; i <= secondDan; i++) {
			for (int j = 1; j <= 9; j++) {
				int result = 0;
				result = i * j;
				System.out.print(i + "*"  + j + "=" + result + "\t");	
			} 
			
			System.out.println();
		}
		
	}

}
