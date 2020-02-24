class Parent2 {
	int x = 100;

	Parent2() {
		this(200);
	}

	Parent2(int x) {
		this.x = x;
	}

	int getX() {
		return x;
	}
}

class Child2 extends Parent2 {

	Child2() {
		this(1000);
	}

	Child2(int x) {
		this.x = x;
	}
	
	int getX() {

		return x;
	}
}

public class ConstructorTest4 {
	public static void main(String[] args) {
		Child2 c = new Child2();

		System.out.println("x=" + c.getX());
	}
}