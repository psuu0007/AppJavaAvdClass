package supertest;

public class Point3D extends Point{
	int z = 0;
	Point3D(int x, int z) {
		super.x = x;
		this.y = 2;
		this.z = z;
	}
	
	Point3D(int x) {
		this(x, 50);
	}
	
	String getLocation() { 
		String resultStr = "";
		resultStr = super.getLocation()
				+ ", z: " + z;
		return resultStr; 
	}
	
}
