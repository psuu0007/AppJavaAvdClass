
//메서드 명명규칙
//변수랑 동일
public class ParameterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		callByValue vs callByReference
//		값 호출                   값 참조
//		
//		기본형 매개변수 - 변수의 값을 읽기만 할 수 있다(read only)
//		참조형 매개변수 - 변수의 값을 읽고 변경할 수 있다(read & write)
//		
		Data data = new Data();
		
		int x = 0;
		
		x = 10;
		System.out.println("main x = " + x);
		
		data.change(x);
		
		System.out.println("After change");
		System.out.println("main x = " + x);
		
	}

}
