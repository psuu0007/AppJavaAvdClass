package supertest;

public class Point {
	int x = 0; 
	int y = 0;
	Point(){
		this.x = 10;
		y = 20;
	}
	Point(int x){
		this.x = x;
		y = 30;
	}
	
	String getLocation() {
		String resultStr = "";
		resultStr = "x: " + x + ", y: " + y;
		return resultStr; 
	}
	
}

