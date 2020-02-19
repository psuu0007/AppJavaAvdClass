
//메서드 명명규칙
//변수랑 동일
public class ParameterTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Data2 data2 = new Data2();
		int x = 0;
		
		x = 10;
		data2.x = x;
		
		System.out.println("main data2.x = " + data2.x);
		System.out.println(data2);
		data2.change(data2.x);
		
		System.out.println("After change");
		System.out.println("main data2.x = " + data2.x);
		
	}

}
