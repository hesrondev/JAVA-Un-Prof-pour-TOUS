package com.ingesup.labojava.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.IteratorImpl;
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
	public void addProfessor(Professor prof) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(prof);
		logger.info("Professor saved successfully, Professor details : "+ prof);
	}

	@Override
	public void updateProfessor(Professor prof) {
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

	@SuppressWarnings("unchecked")
	@Override
	public Professor getProfessor(String email, String pass) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Professor p where p.email = :email and p.password = :password");
		query.setParameter("email", email);
		query.setParameter("password", pass);
		
		List<Professor> profList = query.list();
		
		if (profList.isEmpty())
			return null;
		
		logger.info("Professor loaded successfully, Professor Details:"+ profList.get(0));
		
		return profList.get(0);
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
