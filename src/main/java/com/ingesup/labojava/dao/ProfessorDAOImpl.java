package com.ingesup.labojava.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ingesup.labojava.bean.Professor;

@Repository
public class ProfessorDAOImpl implements ProfessorDAO{

	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void addProfessor(Professor prof) {
		entityManager.persist(prof);
		logger.info("Professor saved successfully, Prof details : "+ prof);		
	}

	public void updateProfessor(Professor prof) {
		
	}

	@SuppressWarnings("unchecked")
	public List<Professor> getProfessorList() {
		
		Query query = entityManager.createQuery("Select p from Professor p");
		
		
		List<Professor> profList = query.getResultList();
		
		for (Professor p : profList)
			logger.info("Prof-List :: "+ p);
		return profList;
	}

	
	@SuppressWarnings("unchecked")
	public Professor getProfessor(String email, String pass) {
		
		
		Query query = entityManager.createQuery("from Professor p where p.email = :email and p.password = :password");
		query.setParameter("email", email);
		query.setParameter("password", pass);
		
		List<Professor> profList = query.getResultList();
		
		if (profList.isEmpty())
			return null;
		
		logger.info("Student loaded successfully, Student Details:"+ profList.get(0));
		
		return profList.get(0);
	}

	public void removeProfessor(Long id) {
		
	}

}
