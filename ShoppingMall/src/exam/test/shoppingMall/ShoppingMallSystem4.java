package exam.test.shoppingMall;

public class ShoppingMallSystem4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer[] customerArr = new Customer[10];
		
		customerArr[0] = new Customer("박지훈", 26, 100);
		customerArr[1] = new Customer("차정경", 24, 100);
		customerArr[2] = new Customer("정의광", 29, 100);
		customerArr[3] = new Customer("노재민", 10, 100);
		customerArr[4] = new Customer("김용훈", 26, 100);
		customerArr[5] = new Customer("박상아", 30, 100);
		customerArr[6] = new Customer("원아름", 27, 100);
		customerArr[7] = new Customer("오현석", 27, 100);
		customerArr[8] = new Customer("정제건", 25, 100);
		customerArr[9] = new Customer("이찬양", 25, 100);
		
		Customer customer = customerArr[0];
		customer.info();
		
		ProductStore computerStore = new ProductStore("최고의 컴퓨터", 10);
		ProductStore mart = new ProductStore("연필", 1);
		ProductStore penMart = new ProductStore("볼펜", 3);
		ProductStore eraMart = new ProductStore("지우개", 5);
		ProductStore whiteMart = new ProductStore("화이트", 1);
		ProductStore noteMart = new ProductStore("공책", 2);
		
		computerStore.buy(customerArr[0]);
		System.out.println(customerArr[0]);
		System.out.println(computerStore);
		System.out.println();
		
		mart.buy(customerArr[1]);
		System.out.println(customerArr[1]);
		System.out.println(mart);
		System.out.println();
		
		penMart.buy(customerArr[2]);
		System.out.println(customerArr[2]);
		System.out.println(penMart);
		System.out.println();
		
		eraMart.buy(customerArr[3]);
		System.out.println(customerArr[3]);
		System.out.println(eraMart);
		System.out.println();
		
		whiteMart.buy(customerArr[4]);
		System.out.println(customerArr[4]);
		System.out.println(whiteMart);
		System.out.println();
		
		noteMart.buy(customerArr[5]);
		System.out.println(customerArr[5]);
		System.out.println(noteMart);
		System.out.println("사용자 정보 ");
		// 모든 사용자 정보 조회
		
		
		for (int i = 0; i < customerArr.length; i++) {
			System.out.println(customerArr[i]);
		}
		
		
	}

}
