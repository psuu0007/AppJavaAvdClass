package edu.tg.util;

public class Point {

	int x;
	int y;
	
	public Point(){
		
	}
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	String getLocation() {
		return "x : " + x + ", y : " + y;
	}
	
}
