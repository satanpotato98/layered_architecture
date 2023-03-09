package com.manipal.dao;
import java.util.List;

import com.manipal.entity.student;
public interface IStudentdao {
	public int addStudent(student s);
	public List<student> getStudents();
	public int delStudent(int id);
	public int updateStudent(int id, student s);
	
}
