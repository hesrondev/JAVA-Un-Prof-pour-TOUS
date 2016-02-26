package com.ingesup.labojava.service;

import java.util.List;

import com.ingesup.labojava.bean.Professor;

public interface ProfessorService {
	
	public void addProfessor(Professor prof);
	public void updateProfessor(Professor prof);
	public List<Professor> getProfessorList();
	public Professor getProfessor(String email, String pass);
	public void removeProfessor(Long id);

}
