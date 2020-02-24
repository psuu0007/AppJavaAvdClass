package supertest3;

public class Point3D extends Point{
	int x = 1;
	int y = 2;
	int z = 3;
	Point3D() {
		this(100, 200, 300);
	}
	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	String getLocation() { 
		String resultStr = "";
		resultStr = "x: " + super.x 
				+ ", y: " + y
				+ ", z: " + this.z;
		return resultStr; 
	}
}
