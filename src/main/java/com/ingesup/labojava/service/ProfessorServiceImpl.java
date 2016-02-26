package com.ingesup.labojava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.dao.ProfessorDAO;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService{
	
	private ProfessorDAO professorDAO;

	public void setProfessorDAO(ProfessorDAO professorDAO) {
		this.professorDAO = professorDAO;
	}

	@Override
	public void addProfessor(Professor prof) {
		this.professorDAO.addProfessor(prof);
	}

	@Override
	public void updateProfessor(Professor prof) {
		this.professorDAO.updateProfessor(prof);
	}

	@Override
	public List<Professor> getProfessorList() {
		return this.professorDAO.getProfessorList();
	}

	@Override
	public Professor getProfessor(String email, String pass) {
		return this.professorDAO.getProfessor(email, pass);
	}

	@Override
	public void removeProfessor(Long id) {
		this.removeProfessor(id);
	}

}
