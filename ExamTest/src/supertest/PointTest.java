package supertest;

public class PointTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Point3D p3d = new Point3D(9);
		String result = "";
		result = p3d.getLocation();
		System.out.println(result);
		
		p3d = new Point3D(1, 2);
		
		result = p3d.getLocation();
		
		System.out.println(result);
		
	}

}
