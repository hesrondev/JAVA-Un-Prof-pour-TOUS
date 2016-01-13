package com.ingesup.labojava.factory;

import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.form.InscriptionFormBean;

public class StudentFactory {
	
	public Student createStudent() {
		return new Student();
	}
	
	public Student createStudent(InscriptionFormBean ifb) {
		Student student = new Student();
		student.setFirstName(ifb.getFirstName());
		student.setLastName(ifb.getLastName());
		student.setEmail(ifb.getEmail());
		student.setPassword(ifb.getPassword());
		
		return student;
	}

}
