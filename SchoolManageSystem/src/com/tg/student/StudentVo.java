package com.tg.student;

import com.tg.subject.EnglishL;
import com.tg.subject.KoreaL;
import com.tg.subject.MathL;

public class StudentVo {
//	학생번호
	private int no = 0;
//	이름
	private String name = "";

//	국어
	private KoreaL koreaL = null;
//	영어
	private EnglishL englishL = null;
//	수학
	private MathL mathL = null;

//	총점
	private int totalScore = 0;

	public StudentVo() {
		super();
	}

	public StudentVo(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public StudentVo(int no, String name, KoreaL koreaL, EnglishL englishL, MathL mathL) {
		super();
		this.no = no;
		this.name = name;
		this.koreaL = koreaL;
		this.englishL = englishL;
		this.mathL = mathL;
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

	public KoreaL getKoreaL() {
		return koreaL;
	}

	public void setKoreaL(KoreaL koreaL) {
		this.koreaL = koreaL;
	}

	public EnglishL getEnglishL() {
		return englishL;
	}

	public void setEnglishL(EnglishL englishL) {
		this.englishL = englishL;
	}

	public MathL getMathL() {
		return mathL;
	}

	public void setMathL(MathL mathL) {
		this.mathL = mathL;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "StudentVo [no=" + no + ", name=" + name + ", koreaL=" + koreaL + ", englishL=" + englishL + ", mathL="
				+ mathL + ", totalScore=" + totalScore + "]";
	}

}
