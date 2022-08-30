package com.example.lib.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.example.lib.model.StudentDao;
import com.example.lib.vo.Student;

public class InsertController {
	private Scanner scan;

	public InsertController(Scanner scan) {
		this.scan = scan;
	}

	public void doInsert() throws ClassNotFoundException {
		System.out.print("학번 : ");
		String hakbun = this.scan.next();
		System.out.print("이름 : ");
		String irum = this.scan.next();
		System.out.print("국어 : ");
		int kor = this.scan.nextInt();
		System.out.print("영어 : ");
		int eng = this.scan.nextInt();
		System.out.print("수학 : ");
		int math = this.scan.nextInt();

		Student std1 = new Student(hakbun, irum, kor, eng, math);
		int tot = kor + eng + math ; // 총점
		double avg = tot / 3.;  // 평균
		char grade = (avg >= 90 && avg <= 100)? 'A':
						(avg <= 90)?'B':
							(avg <=80)?'C':
								(avg <=70)?'D':'F'; //평점 
		
		std1.setTot(tot); std1.setAvg(avg); std1.setGrade(grade);
		StudentDao dao = new StudentDao();
		try {
			dao.insert(std1);
		} catch (SQLException ex) {
			System.out.println("Insert Failure.");
			System.out.println(ex);
		}
	}
}
