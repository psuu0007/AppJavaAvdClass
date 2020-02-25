package exam.test.shoppingMall;

public class ShoppingMallSystem_ver3 {

	public static void main(String[] args) {
		// 10명의 같은 반 동기들을 생성
		// 5명의 친구들은 모두 컴퓨터를 구입한다
		// 나머지 5명의 친구들은 전혀 다른 가게에서 물건을 하나 구입하시오.
		// 그리고 각 친구들의 정보를 출력
		// 각 가게의 정보를 출력하시오
		
//		동기 생성
		Customer park = new Customer("박상아", 33, 1000);
		Customer oh = new Customer("오현석", 27, 100);
		Customer won = new Customer("원아름", 27, 100);
		Customer lee = new Customer("이정주", 26, 100);
		Customer lee2 = new Customer("이환상", 29, 100);
		Customer yang = new Customer("양우진", 26, 100);
		Customer hong = new Customer("김홍", 27, 100);
		Customer chan = new Customer("이찬양", 25, 100);
		Customer go = new Customer("고재민", 43, 100);
		Customer jung = new Customer("정의광", 29, 100);

//		가게 생성
		ProductStore computerStore = new ProductStore("컴퓨터", 50);
		ProductStore mouseStore = new ProductStore("마우스", 45);
		ProductStore moniterStore = new ProductStore("모니터", 40);
		ProductStore cellphoneStore = new ProductStore("핸드폰", 30);
		ProductStore deskStore = new ProductStore("책상", 20);
		ProductStore cupStore = new ProductStore("컵", 10);

//		물품 구매
		computerStore.buy(park);
		computerStore.buy(oh);
		computerStore.buy(won);
		computerStore.buy(lee);
		computerStore.buy(lee2);

		mouseStore.buy(yang);
		moniterStore.buy(hong);
		cellphoneStore.buy(chan);
		deskStore.buy(go);
		cupStore.buy(jung);

//		친구정보출력
		System.out.println("=========== 친구정보 ===========");
		park.info();

		oh.info();

		won.info();

		lee.info();

		lee2.info();

		System.out.println(yang);

		System.out.println(hong);

		System.out.println(chan.name);
		System.out.println(chan.age);
		System.out.println(chan.money);
		System.out.println(go.name);
		System.out.println(go.age);
		System.out.println(go.money);
		System.out.println(jung.name);
		System.out.println(jung.age);
		System.out.println(jung.money);

//		가게정보출력
		System.out.println("=========== 가게정보 ===========");
		System.out.println(computerStore);
		System.out.println(mouseStore);

		System.out.println(moniterStore.productName);
		System.out.println(moniterStore.price);
		System.out.println(cellphoneStore.productName);
		System.out.println(cellphoneStore.price);
		System.out.println(deskStore.productName);
		System.out.println(deskStore.price);
		System.out.println(cupStore.productName);
		System.out.println(cupStore.price);
	} // main

}
