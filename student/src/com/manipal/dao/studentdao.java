package com.manipal.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manipal.entity.student;

import java.sql.*;

public class studentdao implements IStudentdao {

	private Connection conn;

	public studentdao() {

		this.conn = DButil.getcon();

	}

	@Override
	public int addStudent(student s) {
		// TODO Auto-generated method stub
		String insertQuery = "insert into student(id,name,dept,doj) values(?,?,?,?)";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);

			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setString(3, s.getDept());
			pstmt.setDate(4,s.getDoj());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public List<student> getStudents() {
		List<student> list = new ArrayList<student>();
		
		try {
			Statement stmt =conn.createStatement();
			
			String query = "select id, name, dept, doj from student";
			
		ResultSet rs =	stmt.executeQuery(query);
			
				
			while(rs.next()) {
				
			student s = new student();
			
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setDept(rs.getString("dept"));
				s.setDoj(rs.getDate("doj"));
				
				list.add(s);
	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int delStudent(int id) {
		int count=0;
		String query="delete from student where id = ?";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, id);
			count=psmt.executeUpdate();
		}
		catch (SQLException e1) {
		e1.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateStudent(int id, student s1 ) {
		int count=0;
		String query="update student set name=?,dept=?, doj=?, id=? where id=?";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, s1.getName());
			psmt.setString(2, s1.getDept());
			psmt.setDate(3, s1.getDoj());
			psmt.setInt(4, s1.getId());
			psmt.setInt(5, id);
			count=psmt.executeUpdate();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return count;
	}

}
