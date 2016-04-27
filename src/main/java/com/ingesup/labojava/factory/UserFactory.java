package com.ingesup.labojava.factory;

import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.InscriptionFormBean;
import com.ingesup.labojava.utils.Crypto;

public class UserFactory {
	
	
	// Professor factory
	
	public User createProfessor() {
		return new Professor();
	}
	
	public User createProfessor(InscriptionFormBean ifb) {
		User professor = new Professor();
		professor.setFirstName(ifb.getFirstName());
		professor.setLastName(ifb.getLastName());
		professor.setEmail(ifb.getEmail());
		professor.setGender(ifb.getGender());
		professor.setPassword(Crypto.crypter(ifb.getPassword()));	// On crypte le mot de passe
		
		return professor;
	}
	
	// Student factory
	
	public User createStudent() {
		return new Student();
	}
	
	public User createStudent(InscriptionFormBean ifb) {
		User student = new Student();
		student.setFirstName(ifb.getFirstName());
		student.setLastName(ifb.getLastName());
		student.setEmail(ifb.getEmail());
		student.setGender(ifb.getGender());
		student.setPassword(Crypto.crypter(ifb.getPassword())); // On crypte le mot de passe
		
		return student;
	}

}
