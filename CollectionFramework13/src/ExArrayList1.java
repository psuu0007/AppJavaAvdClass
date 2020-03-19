import java.util.ArrayList;

public class ExArrayList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] numArr = new int[10];
		ArrayList list = new ArrayList();
//		가변
		
//		for (int i = 0; i < numArr.length; i++) {
//			numArr[i] = i + 1;
//		}
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
//		for (int i = 0; i < numArr.length; i++) {
//			System.out.println(numArr[i]);
//		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		} 
				
		
	}

}
