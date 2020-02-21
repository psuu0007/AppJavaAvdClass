
public class Circle {

//	int x;  // 원점의 x좌표
//	int y;	// 원점의 y좌표
//	relation
//	포함관계(has)
	Point point = null;
//	Point point = new Point();
	int r;	// 반지름(radius)
	
	void info() {
		System.out.println("circle의 정보");
		System.out.println(r);
		System.out.println("x " + point.x);
		System.out.println("y " + point.y);
	}
	
}
