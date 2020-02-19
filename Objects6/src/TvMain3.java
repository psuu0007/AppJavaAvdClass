
public class TvMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		복제
		Tv tv = new Tv();
		Tv tv2 = new Tv();

		tv.channel = 7;
		tv.power = true;
		tv.color = "red";

		System.out.println("Tv 정보");
		System.out.println(tv.channel);
		System.out.println(tv.power);
		System.out.println(tv.color);
		
		System.out.println("Tv2 정보");
		System.out.println(tv2.channel);
		System.out.println(tv2.power);
		System.out.println(tv2.color);
		
		tv2 = tv;
		System.out.println("복제 성공함");
		System.out.println();
		
		System.out.println("Tv 정보");
		System.out.println(tv.channel);
		System.out.println(tv.power);
		System.out.println(tv.color);
		
		System.out.println("Tv2 정보");
		System.out.println(tv2.channel);
		System.out.println(tv2.power);
		System.out.println(tv2.color);
		
		tv2.channel = 1000;
		System.out.println("tv2 정보 변경함");
		System.out.println("========================");
		
		System.out.println("Tv 정보");
		System.out.println(tv.channel);
		System.out.println(tv.power);
		System.out.println(tv.color);
		
		System.out.println("Tv2 정보");
		System.out.println(tv2.channel);
		System.out.println(tv2.power);
		System.out.println(tv2.color);
		
		
	}

}
