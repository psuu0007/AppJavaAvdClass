
public class TestIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "1";
//		System.out.println(str == "y");
		if(!(str == "y" || str == "n")) {
			System.out.println("!(Str == \"y\" || Str == \"n\")");
		}else {
			System.out.println("????????????");
		}
//		
		if(!(str == "y" || str == "n")) {
			System.out.println("!(Str == \"y\" || Str == \"n\")");
		}else if(str == "y" || str == "n"){
			System.out.println("????????????");
		}
		
		if(!(str == "y" || str == "n")) {
			System.out.println("!(Str == \"y\" || Str == \"n\")");
		}else if(!(str != "y" && str != "n")){
			System.out.println("????????????");
		}
		
		if(str == "y" || str == "n") {
			System.out.println("참인경우");
		}else {
			System.out.println(312213);
		}
		
		if(str == "y" || str == "n") {
			System.out.println("참인경우");
		}else if(str != "y" && str != "n"){
			System.out.println(312213);
		}
	}

}
