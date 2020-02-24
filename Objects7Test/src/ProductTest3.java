class Product3 
{
	int price;		// 제품의 가격
	// 제품구매 시 제공하는 보너스점수
	int bonusPoint;		

	public Product3() {
		// TODO Auto-generated constructor stub
	}
	
	Product3(int price) {
		this.price = price;
		bonusPoint =(int)(price/10.0);
	}
}

class Tv3 extends Product3 {
	Tv3() {
		super();
	}
	
	Tv3(int x){
		super();
	}

}

public class ProductTest3 {
	public static void main(String[] args) {
		Tv3 t = new Tv3();
		System.out.println("제품의 가격: " + t.price);
		System.out.println("보너스 점수" + t.bonusPoint);
	}
}