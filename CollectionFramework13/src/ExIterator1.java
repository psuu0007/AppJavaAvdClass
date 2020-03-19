import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExIterator1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList();
		List<Integer> list2 = new ArrayList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list2.add(2);
		list2.add(100);

		List<Integer> resultNumList = new ArrayList();

		for (int i = 0; i < list2.size(); i++) {
			for (int n = 0; n < list.size(); n++) {
				resultNumList.add(list.get(n) * list2.get(i));
			}
		}

		Iterator<Integer> it = resultNumList.iterator();

		while (it.hasNext()) {
			Object obj = it.next();

			System.out.println(obj);
			System.out.println(obj);
			System.out.println(obj);
//			System.out.println(it.next());
//			System.out.println(it.next());
		}
	}

}
