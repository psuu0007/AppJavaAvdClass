package com.tg.polymorphism;

public class Tv {

	boolean power; // 전원 (on/off)
	int channel;   // 채널
	
	void power() {
		power = !power;
	}
	
	void channelUp() {
		System.out.println("된거야");
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
	
}
