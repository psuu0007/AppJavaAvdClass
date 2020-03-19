package com.tg.subject;

public class Subject {

	private String name = "";
	private int score = 0;

	public Subject() {
		super();
	}

	public Subject(String name) {
		super();
		this.name = name;
	}
	
	public Subject(String name, int score) {
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
		return "Subject [name=" + name + ", score=" + score + "]";
	}

}
