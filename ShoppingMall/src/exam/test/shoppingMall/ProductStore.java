package exam.test.shoppingMall;

// 어떤 단 하나의 물건만 팔수있는 매장
public class ProductStore {
	
	int storeMoney = 0;  // 주인장의 소지금
	int price = 0; // 제품의 가격
	String productName = "";
	
	
	ProductStore(String productName, int price){
		storeMoney = 1000000; // 초기자금은 무조건 100만원
		this.price = price;
		this.productName = productName;
	}
	
	void buy(Customer customer){
		if(customer.money >= this.price){
			customer.money = customer.money - this.price; 
			storeMoney = storeMoney + this.price;
			System.out.println(this.productName + "를 구입하셨습니다.");
		}else{
			System.out.println(this.productName + "제품을 구입하기에 ");
			System.out.println(customer.money - this.price + " 원 부족합니다.");
		}
	}

	@Override
	public String toString() {
		return "ProductStore [storeMoney=" + storeMoney 
				+ ", price=" + price + ", productName=" + productName + "]";
	}
	
	
	
}
