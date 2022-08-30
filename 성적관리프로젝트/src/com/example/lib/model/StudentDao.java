package com.example.lib.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.example.DBClose;
import com.example.DBConnection;
import com.example.lib.vo.Student;

public class StudentDao {
	private DBConnection dbconn;
	
	public StudentDao() {
		this.dbconn = new DBConnection(com.example.lib.view.Main.path);
	}
	
	public void insert(Student std) throws ClassNotFoundException, SQLException {
		Connection conn = this.dbconn.getConnection(); // 1,2
		
		//3 Statement °´Ã¼ »ý¼º
//		String sql = "INSERT INTO Student(hakbun,irum,kor,eng,math) VALUES(?,?,?,?,?)";
		
		// 3-1. 
		String sql = "{call sp_student_insert(?,?,?,?,?,?,?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, std.getHakbun());
		cstmt.setString(2, std.getIrum());
		cstmt.setInt(3, std.getKor());
		cstmt.setInt(4, std.getEng());
		cstmt.setInt(5, std.getMath());
		cstmt.setDouble(6, std.getTot());
		cstmt.setDouble(7, std.getAvg());
		cstmt.setString(8, std.getGrade()+"");
		
		//4.
		cstmt.execute();
		
		// 6
		DBClose.close(conn);
		
	}

	public Vector<Student> selectAll() throws ClassNotFoundException, SQLException {
		Connection conn = this.dbconn.getConnection(); // 1,2
		//3.
		String sql ="{call sp_student_selectAll()}";
		CallableStatement cstmt = conn.prepareCall(sql);
		//4.
		ResultSet rs = cstmt.executeQuery();
		Vector<Student> vector = new Vector<Student>(1,1);
		
		
		while(rs.next()) {
			Student std = new Student(rs.getString("hakbun"), rs.getString("irum"),
							rs.getInt("kor"),rs.getInt("eng"),rs.getInt("math"));
			std.setTot(rs.getInt("tot"));
			std.setAvg(rs.getDouble("avg"));
			std.setGrade(rs.getString("grade").charAt(0));   // "B"   ---> 'B'
		}
		
		DBClose.close(conn);
		return vector;
	}
}
