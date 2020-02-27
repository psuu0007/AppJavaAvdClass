
public class Customer {

	// 소유금액
	int money = 1000;
	// 보너스점수
	int bonusPoint = 0;
	
	void buy(Product product) {
		
		if(money < product.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다");
			return;
		}
		
		money = money - product.price;
		bonusPoint = bonusPoint + product.bonusPoint;
		System.out.println(product + "을/를 구입하셨습니다");
	}
	
//	void buy(Audio audio) {
//		if(money < audio.price) {
//			System.out.println("잔액이 부족하여 물건을 살 수 없습니다");
//			return;
//		}
//		
//		money = money - audio.price;
//		bonusPoint = bonusPoint + audio.bonusPoint;
//		System.out.println(audio + "을 구입하셨습니다");
//	}
//	
//	void buy(Computer com) {
//		if(money < com.price) {
//			System.out.println("잔액이 부족하여 물건을 살 수 없습니다");
//			return;
//		}
//		
//		money = money - com.price;
//		bonusPoint = bonusPoint + com.bonusPoint;
//		System.out.println(com + "을 구입하셨습니다");
//	}

	@Override
	public String toString() {
		return "Customer [money=" + money + ", bonusPoint=" 
				+ bonusPoint + "]";
	}
	
	
}
