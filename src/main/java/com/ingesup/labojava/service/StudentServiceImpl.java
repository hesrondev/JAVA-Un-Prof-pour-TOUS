package com.ingesup.labojava.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.dao.StudentDAO;


@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void addStudent(Student std) {
		this.studentDAO.addStudent(std);
	}

	@Override
	public Student updateStudent(Student std) {
		return this.studentDAO.updateStudent(std);
	}

	@Override
	public List<Student> listStudents() {
		return this.studentDAO.listStudents();
	}

	@Override
	public Student getStudent(String email, String pass) {
		return this.studentDAO.getStudent(email, pass);
	}
	
	@Override
	public Student getStudent(Long ID) {
		// TODO Auto-generated method stub
		return this.studentDAO.getStudent(ID);
	}

	@Override
	public void removeStudent(Long id) {
		this.studentDAO.removeStudent(id);		
	}

	

}
