package com.tg.student;

public class StudentVo {
//	학생번호
	private int no = 0;
//	이름
	private String name = "";

	public StudentVo() {
		super();
	}

	public StudentVo(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentVo [no=" + no + ", name=" + name + "]";
	}

}
