package com.ingesup.labojava.service;

import java.util.List;

import com.ingesup.labojava.bean.Student;

public interface StudentService {
	
	public void addStudent(Student std);
	public Student updateStudent(Student std);
	public List<Student> listStudents();
	public Student getStudent(String email, String pass);
	public Student getStudent(Long ID);
	public void removeStudent(Long id);

}
