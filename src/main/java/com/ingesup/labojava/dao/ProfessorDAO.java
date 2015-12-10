package com.ingesup.labojava.dao;

import java.util.List;

import com.ingesup.labojava.bean.Professor;

public interface ProfessorDAO {
	
	public void addPerson(Professor prof);
	public void updatePerson(Professor prof);
	public List<Professor> listProfessors();
	public Professor getProfessor(String email, String pass);
	public void removeProfessor(Long id);
	
}
