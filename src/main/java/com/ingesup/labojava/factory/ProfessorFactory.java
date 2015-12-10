package com.ingesup.labojava.factory;

import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.form.InscriptionFormBean;

public class ProfessorFactory {
	
	public Professor createProfessor() {
		return new Professor();
	}
	
	public Professor createProfessor(InscriptionFormBean ifb) {
		Professor professor = new Professor();
		professor.setFirstName(ifb.getFirstName());
		professor.setLastName(ifb.getLastName());
		professor.setEmail(ifb.getEmail());
		professor.setPassword(ifb.getPassword());
		
		return professor;
	}
	

}
