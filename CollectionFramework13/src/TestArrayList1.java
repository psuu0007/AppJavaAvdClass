import java.util.ArrayList;

public class TestArrayList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList list = new ArrayList();
		ArrayList list2 = new ArrayList();
		
		for (int i = 0; i < 9; i++) {
			list.add(i+1);
		}
		
		for (int i = 0; i < 2; i++) {
			list2.add(i+2);
		}
		
		int num = (int)list.get(0);
		
		System.out.println(num);
		
		
	}

}
