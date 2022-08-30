package com.example.lib.controller;

import java.sql.SQLException;
import java.util.Vector;

import com.example.lib.model.StudentDao;
import com.example.lib.vo.Student;

public class SelectAllController {

	public void doSelectAll() throws ClassNotFoundException {
		Vector<Student> vector = null;
		try {
			StudentDao dao = new StudentDao();
			vector = dao.selectAll();
			for(int i = 0; i < vector.size(); i++) {
				System.out.println(vector.get(i));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		
	}
	
}
