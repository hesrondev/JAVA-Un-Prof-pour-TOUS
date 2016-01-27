package com.ingesup.labojava.dao;

import java.util.List;

import com.ingesup.labojava.bean.Student;


public interface StudentDAO {
	
	public void addStudent(Student std);
	public void updateStudent(Student std);
	public List<Student> listStudents();
	public Student getStudent(String email, String pass);
	public void removeStudent(Long id);

}
