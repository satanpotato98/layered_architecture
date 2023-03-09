package com.manipal.service;

import java.util.List;

import com.manipal.dao.*;
import com.manipal.entity.student;

public class StudentService implements IStudentService {

	private  IStudentdao dao;
	
	public StudentService() {
		
		dao = new studentdao();
	}
	@Override
	public int addStudent(student s) {
		return dao.addStudent(s);
	}

	@Override
	public List<student> getStudents() {
		return dao.getStudents();
	}
	@Override
	public int delStudent(int id) {
		return dao.delStudent(id);
	}
	@Override
	public int updateStudent(int id, student s) {
		return dao.updateStudent(id, s);
	}

}
