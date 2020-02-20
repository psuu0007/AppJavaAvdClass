import java.util.Scanner;

//구구단이 존재한다

//생성자를 통해 단을 입력한다

//입력된 단을 출력한다
//입력된 단을 출력한다
public class Gugudan {

	int dan = 0;
	String title = "";
		
	
	Gugudan(String title){           //생성자
		this.title = title;	
	}
	
	void input(){             //메서드
		Scanner sc = new Scanner(System.in);
		System.out.println("단을 입력해 주세요");
		
		dan = sc.nextInt();	
	}
	
	void output(){		
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + "*" + i + " = " + (dan*i));
		}		
	
	}
		
	void service() {
		String str = "";
		Scanner scan = new Scanner(System.in); 
		while (true) {
			input();
			output();
			
			System.out.println("종료할래요?y/n");
			str = scan.nextLine();
			if(str.equals("y")) {
				break;
			}
		}
	}
	
	void info() {
		System.out.println(title);
	}
	
}
