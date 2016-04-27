package com.ingesup.labojava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void addStudent(Student std) {
		entityManager.persist(std);
		logger.info("Student saved successfully, Student details : "+ std);		
	}

	// Mise à Jour de de l'utilisateur
	
	@Override
	public Student updateStudent(Student std) {
		
		return entityManager.merge(std);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudents() {
		
		Query query = entityManager.createQuery("select s from Student s");	
		
		List<Student> stdList = query.getResultList();
		
		for (Student s : stdList)
			logger.info("Student-List :: "+ s);
		return stdList;
	}

	
	// Récupération de l'utilisateur par email et mot de passe
	
	@SuppressWarnings("unchecked")
	@Override
	public Student getStudent(String email, String pass) {
		
		Query query = entityManager.createQuery("from Student s where s.email = :email and s.password = :password");
		query.setParameter("email", email);
		query.setParameter("password", pass);
		
		List<Student> stdList = query.getResultList();
		
		if (stdList.isEmpty())
			return null;
		
		logger.info("Student loaded successfully, Student Details:"+ stdList.get(0));
		
		return stdList.get(0);
	}
	
	
	// Récupération de l'utilisateur par ID

	@SuppressWarnings("unchecked")
	@Override
	public Student getStudent(Long ID) {
		
		Query query = entityManager.createQuery("from Student s where s.id = :id");
		query.setParameter("id", ID);
		
		List<Student> stdList = query.getResultList();
		
		if (stdList.isEmpty())
			return null;
		
		logger.info("Student loaded successfully, Student Details:"+ stdList.get(0));
		
		return stdList.get(0);
	}


	// Récupération de la liste des annonces de l'utilisateur
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Annonce> getAllAdsByStudent(Long studentId) {
		
		
		Query query = entityManager.createQuery("from Annonce a where a.STUDENT_ID = :id");
		query.setParameter("id", studentId);
		
		List<Annonce> adsList = query.getResultList();
		
		for (Annonce ad : adsList)
			logger.info("Student-AD-List :: "+ ad);
		
		return adsList;
	}	
	
	// Suppression d'un utilisateur
	
		@Override
		public void removeStudent(Long id) {
			
			Query query = entityManager.createQuery("delete from Student s where s.id = :id");
			query.setParameter("id", id);
			
			int n = query.executeUpdate();
			
			if (n > 0) 
				logger.info("[REQ]: " + n + "students deleted !");
		}

}
