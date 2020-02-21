
public class DrawShape {

	public static void main(String[] args) {
		
		Circle circle = new Circle();
		
		circle.r = 5;
		
		Point p = new Point();
		
//		circle.point.x = 2;
//		circle.point.y = 3;
		
		p.x = 2;
		p.y = 3;
		
		circle.point = p;
		
//		circle.info();
	
		Point p1 = new Point(2, 3);
		Point p2 = new Point(5, 3);
		Point p3 = new Point(3, 10);
		
		Point[] pointArr = new Point[3];
		for (int i = 0; i < pointArr.length; i++) {
			pointArr[i] = new Point(i+1, i+2);
		}
//		pointArr[0] = 
//		pointArr[1] = new Point(5, 3);
//		pointArr[2] = new Point(3, 10);
		
		Triangle tri = new Triangle(pointArr);
//		Triangle tri = new Triangle(p1, p2, p3);
		
		tri.info();
		
	}
	
}
