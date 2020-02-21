
public class Triangle {

	Point[] pointArr = new Point[3];
	
	public Triangle(Point[] pointArr) {
		this.pointArr = pointArr;
	}
	
	public Triangle(Point p1, Point p2, Point p3) {
		pointArr[0] = p1;
		pointArr[1] = p2;
		pointArr[2] = p3;
	}
	
	void info() {
		for (int i = 0; i < pointArr.length; i++) {
			System.out.println("x: " + pointArr[i].x 
					+ ", y: " + pointArr[i].y);
		}
	}
	
}
