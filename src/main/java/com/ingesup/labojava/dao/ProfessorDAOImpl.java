package com.ingesup.labojava.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ingesup.labojava.bean.Professor;

@Repository
public class ProfessorDAOImpl implements ProfessorDAO{

	private static final Logger logger = LoggerFactory.getLogger(ProfessorDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void addPerson(Professor prof) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(prof);
		logger.info("Professor saved successfully, Professor details : "+ prof);
	}

	@Override
	public void updatePerson(Professor prof) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(prof);
		logger.info("Professor updated successfully, Professor details : "+ prof);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> listProfessors() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Professor> profList = session.createQuery("from Professor").list();
		
		for (Professor p : profList)
			logger.info("Professor List :: "+ p);
		return profList;
	}

	@Override
	public Professor getProfessor(String email, String pass) {
		Session session = this.sessionFactory.getCurrentSession();
		Professor prof = (Professor) session.load(Professor.class, new String(email));
		
		if (prof != null)
			logger.info("Professor loaded successfully, Professor Details:"+ prof);
		
		return prof;
	}

	@Override
	public void removeProfessor(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Professor prof = (Professor) session.load(Professor.class, new Long(id));
		
		if (prof != null)
			session.delete(prof);
		
		logger.info("Professor deleted successfully, professor details:"+ prof);
	}

}
