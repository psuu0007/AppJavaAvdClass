package supertest3;

public class Point {
	int x = 10; 
	int y = 20;
	int z = 30;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	String getLocation() {
		String resultStr = "";
		resultStr = "x: " + x 
				+ ", y: " + y;
		return resultStr; 
	}
	
}

