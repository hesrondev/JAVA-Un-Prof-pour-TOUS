package com.ingesup.labojava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.bean.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	
	// EntityManager
	
	@PersistenceContext
	EntityManager entityManager;

	
	/*
	 * ADD a user
	 * */
	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	
	/*
	 * UPDATE a user
	 * */
	
	@Override
	public User updateUser(User user) {
		return entityManager.merge(user);
	}
	
	/*
	 * GET all users
	 * */

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		
		Query query = entityManager.createQuery("select u from User u");
		List<User> users = query.getResultList();
		
		return users;
	}

	/*
	 * Params: email, pass
	 * Return an user
	 * */
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String email, String pass) {
		
		Query query = entityManager.createQuery("from User u where u.email = :email AND u.password = :password");
		query.setParameter("email", email);
		query.setParameter("password", pass);
		
		List<User> users = query.getResultList();
		
		if (users.isEmpty())
			return null;
		
		return users.get(0);
	}

	
	/*
	 * Get an user by id
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public User getUser(Long userID) {
		
		Query query = entityManager.createQuery("from User u where u.id = :id");
		query.setParameter("id", userID);
		
		List<User> users = query.getResultList();
		
		if (users.isEmpty())
			return null;
		
		return users.get(0);
	}

	
	/*
	 * Also deleted from Student & Professor classes
	 * */
	
	@Override
	public void removeUser(Long userID) {
		
		Query query = entityManager.createQuery("delete from User u where u.id = :id");
		query.setParameter("id", userID);
		
		query.executeUpdate();
		
	}
	
	/*
	 * Get all ads
	 * */

	@SuppressWarnings("unchecked")
	@Override
	public List<Annonce> getAllAds() {
		
		Query query = entityManager.createQuery("select a from Annonce a");
		List<Annonce> annonces = query.getResultList();
		
		return annonces;
	}

	/*
	 * Get All ads by User
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<Annonce> getAllAdsByUser(Long userID) {
		
		Query query = entityManager.createQuery("from Annonce a where a.USER_ID = :id");
		query.setParameter("id", userID);
		
		List<Annonce> adList = query.getResultList();
		
		return adList;
		
	}
	
	
	/*
	 * Getting the students and professors List
	 * */

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		Query query = entityManager.createQuery("select s from Student s");
		List<Student> students = query.getResultList();
		
		return students;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> getAllProfessors() {
		Query query = entityManager.createQuery("select p from Professor p");
		List<Professor> professors = query.getResultList();
		
		return professors;
	}

}
