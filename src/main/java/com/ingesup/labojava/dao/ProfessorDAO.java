package com.ingesup.labojava.dao;

import java.util.List;

import com.ingesup.labojava.bean.Professor;

public interface ProfessorDAO {
	
	public void addProfessor(Professor prof);
	public void updateProfessor(Professor prof);
	public List<Professor> getProfessorList();
	public Professor getProfessor(String email, String pass);
	public void removeProfessor(Long id);
	
}
