package com.example.lib.vo;

public class Student {
	private String hakbun;
	private String irum;
	private int kor;
	private int eng;
	private int math;
	private double tot;
	private double avg;
	private char grade;

	public Student(String hakbun, String irum, int kor, int eng, int math) {
		this.hakbun = hakbun;
		this.irum = irum;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public double getTot() {
		return tot;
	}

	public void setTot(double tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [hakbun=" + hakbun + ", irum=" + irum + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", tot=" + tot + ", avg=" + avg + ", grade=" + grade + "]";
	}

}
