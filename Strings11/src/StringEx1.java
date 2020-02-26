
public class StringEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		System.out.println(v1.hashCode());
		System.out.println(v2.hashCode());
		
		System.out.println(v1);
		System.out.println(v2);
//		
//		System.out.println(10 == 10);
//		System.out.println("as" == "as");
		
		System.out.println(v1 == v2);
		
		if(v1.equals(v2) == true) {
			System.out.println("v1과 v2는 같습니다");
		}else {
			System.out.println("v1과 v2는 다릅니다");
		}
		
		v2 = v1;
		
		
		
		if(v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다");
		}else {
			System.out.println("v1과 v2는 다릅니다");
		}
		
	}

}
