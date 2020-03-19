package com.tg.subject;

public class EnglishL {

	private String name = "";
	private int score = 0;

	public EnglishL() {
		super();
	}

	public EnglishL(String name) {
		super();
		this.name = name;
	}
	
	public EnglishL(String name, int score) {
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
		return "EnglishL [name=" + name + ", score=" + score + "]";
	}

}
