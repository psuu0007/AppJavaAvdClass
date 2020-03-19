import java.util.ArrayList;

public class ExArrayList4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ArrayList<String> titleStrList = new ArrayList(); 
		
		titleStrList.add("인베이젼스");
		titleStrList.add("이노베이션");
		titleStrList.add("오벨리스크");
		titleStrList.add("다운폴");
		
		for (int i = 0; i < titleStrList.size(); i++) {
			System.out.println(titleStrList.get(i));
		}
		
//		1~4 까지
//		list에 담아서 모든 숫자의 총합을 구하시오
		ArrayList<Integer> numList = new ArrayList();
		for (int i = 0; i < 4; i++) {
			numList.add(i+1);
		}
		
		showSum(numList);
		
	}
	
//	메인에서 메서드 만들어서; 리턴 없이 출력
//	가능한 제너릭 쓰자
	public static void showSum(ArrayList<Integer> numList) {
		int sum = 0;
		
		for (int i = 0; i < numList.size(); i++) {
			sum = sum + numList.get(i);
		}
		
		System.out.println(sum);
	}
}
