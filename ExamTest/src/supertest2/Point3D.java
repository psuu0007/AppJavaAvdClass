package supertest2;

public class Point3D extends Point{
	int z = 30;
	Point3D() {
		this(100, 200, 300);
	}
	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	String getLocation() { 
		int x = 0;
		int y = 1;
		int z = 2;
		String resultStr = "";
		resultStr = "x: " + super.x 
				+ ", y: " + y
				+ ", z: " + this.z;
		return resultStr; 
	}
}
