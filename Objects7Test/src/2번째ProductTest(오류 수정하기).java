class Product 
{
	int price;		// 제품의 가격
	// 제품구매 시 제공하는 보너스점수
	int bonusPoint;		

	Product(int price) {
		this.price = price;
		bonusPoint =(int)(price/10.0);
	}
}

class Tv extends Product {
	Tv(){
		
	}
}




public class ProductTest {
	public static void main(String[] args) {
		Tv t = new Tv();
		System.out.println("제품의 가격: " + t.price);
		System.out.println("보너스 점수" + t.bonusPoint);
	}
}