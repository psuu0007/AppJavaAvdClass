package exam.test.shoppingMall;
public class ShoppingMallSystem_ver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 10명의 같은 반 동기들을 생성
		// 5명의 친구들은 모두 컴퓨터를 구입한다
		// 나머지 5명의 친구들은 전혀 다른 가게에서 물건을 하나 구입하시오.
		// 그리고 각 친구들의 정보를 출력
		// 각 가게의 정보를 출력하시오 (가장 나중에)
		
		String[] nameArr = new String[10];
		nameArr[0] = "류제건";
		nameArr[1] = "이정주";
		nameArr[2] = "박지훈";
		nameArr[3] = "이환상";
		nameArr[4] = "황지원";
		nameArr[5] = "원아름";
		nameArr[6] = "양우진";
		nameArr[7] = "오현석";
		nameArr[8] = "김홍";
		nameArr[9] = "박상아";
		
		for (int i = 0; i < 5; i++) {
			System.out.println(nameArr[0] + " 컴퓨터 구입");
		}
		
//		System.out.println(nameArr[1] + " 컴퓨터 구입");
//		System.out.println(nameArr[2] + " 컴퓨터 구입");
//		System.out.println(nameArr[3] + " 컴퓨터 구입");
//		System.out.println(nameArr[4] + " 컴퓨터 구입");
		
		System.out.print(nameArr[5]);
		System.out.println(" 사과 구입");
		System.out.print(nameArr[6]);
		System.out.println(" 배 구입");
		System.out.print(nameArr[7]);
		System.out.println(" 포도 구입");
		System.out.print(nameArr[8]);
		System.out.println(" 복숭아 구입");
		System.out.print(nameArr[9]);
		System.out.println(" 수박 구입");
		
		System.out.print("컴퓨터 가게");
		System.out.println("에서 5개의 컴퓨터를 팔았습니다.");
		
		System.out.print("과일 가게");
		System.out.println("에서 1개의 사과를 팔았습니다.");
		
		System.out.print("과일 가게");
		System.out.println("에서 1개의 배를 팔았습니다.");
		
		System.out.print("과일 가게");
		System.out.println("에서 1개의 포도를 팔았습니다.");
		
		System.out.print("과일 가게");
		System.out.println("에서 1개의 복숭아를 팔았습니다.");
		
		System.out.print("마트");
		System.out.println("에서 1개의 수박을 팔았습니다.");
		
		
	}

}
