package com.tg.subject;

public class MathL {

	private String name = "";

	public MathL() {
		super();
	}

	public MathL(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MathL [name=" + name + "]";
	}
	
}
