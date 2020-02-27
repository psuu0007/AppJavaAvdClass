
public class Product {

	// 제품 가격
	int price;
	// 제품 구매시 포인트
	int bonusPoint = 0;

	Product(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0); // 보너스 점수는 제품가격의 10%
	}

	@Override
	public String toString() {
		return "Prduct [price=" + price 
				+ ", bonusPoint=" + bonusPoint + "]";
	}
	
	
	
}
