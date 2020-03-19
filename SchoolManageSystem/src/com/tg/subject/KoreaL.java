package com.tg.subject;

public class KoreaL {

	private String name = "";
	private int score = 0;

	public KoreaL() {
		super();
	}

	public KoreaL(String name) {
		super();
		this.name = name;
	}

	public KoreaL(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "KoreaL [name=" + name + ", score=" + score + "]";
	}

}
