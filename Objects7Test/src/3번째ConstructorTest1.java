package exam.test;
// 
class Product {
	int price; // 제품의 가격
	int bonusPoint; // 제품구매 시 제공하는 보너스점수

	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
}

class Tv extends Product {
	Tv() {
		// 이곳에서 에러가 발생하는데 코드를 어떻게 변경해야 해결이 되는지 코드를 작성하시오
		// 2가지 해결 방법 존재
	}
}

public class ConstructorTest1 {
	public static void main(String[] args) {
		Tv t = new Tv();
		System.out.println("제품의 가격: " + t.price);
		System.out.println("보너스 점수" + t.bonusPoint);
	}
}