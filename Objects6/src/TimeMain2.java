
public class TimeMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Time koreanTime = new Time();
		Time vietNamTime = new Time(); 
		
		System.out.println("한국 시간");

		koreanTime.setHour(17);
		System.out.print(koreanTime.hour + ":");
		koreanTime.minute = 39;
		System.out.print(koreanTime.minute + ":");
		koreanTime.second = 55;
		System.out.println(koreanTime.second);
		
		System.out.println("베트남 시간");
		vietNamTime.hour = 15;
		System.out.print(vietNamTime.hour + ":");
		vietNamTime.minute = 39;
		System.out.print(vietNamTime.minute + ":");
		vietNamTime.second = 55;
		System.out.println(vietNamTime.second);
	}

}
