
public class PointTest4 {
	public static void main(String argsp[]) {
		Point3D4 p3 = new Point3D4();
		System.out.println("p3.x=" + p3.x);
		System.out.println("p3.y=" + p3.y);
		System.out.println("p3.z=" + p3.z);
		
		p3.view();
	}
}

class Point4 {
	int x = 10;
	int y = 20;

	Point4(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Point3D4 extends Point4 {
	int z = 30;

	Point3D4() {
		this(100, 200, 300); // Point3D(int x, int y, int z)호출
	}

	Point3D4(int x, int y, int z) {
		super(x, y); // Point(int x, int y)호출
		this.z = z;
	}
	
	void view() {
		System.out.println(super.x);
	}
	
}