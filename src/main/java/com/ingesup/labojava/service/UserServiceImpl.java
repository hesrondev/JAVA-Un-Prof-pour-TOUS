package com.ingesup.labojava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.dao.UserDAO;
import com.ingesup.labojava.form.AnnonceFormBean;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	
	// User DAO
	
	private UserDAO userDAO;
	
	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	@Override
	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}
	
	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	
	@Override
	public User getUser(String email, String pass) {
		return userDAO.getUser(email, pass);
	}
	
	@Override
	public User getUser(Long userID) {
		return userDAO.getUser(userID);
	}
	
	@Override
	public void removeUser(Long userID) {
		userDAO.removeUser(userID);
	}
	
	@Override
	public List<Student> getAllStudents() {
		return userDAO.getAllStudents();
	}
	
	@Override
	public List<Professor> getAllProfessors(){
		return userDAO.getAllProfessors();
	}
	
	// Ads
	
	@Override
	public List<Annonce> getAllAds() {
		return userDAO.getAllAds();
	}
	
	@Override
	public List<Annonce> getAllAdsByUser(Long userID) {
		return userDAO.getAllAdsByUser(userID);
	}
	
	@Override
	public List<Annonce> getFilteredAds(AnnonceFormBean afb) {
		return userDAO.getFilteredAds(afb);
	}
	
	@Override
	public List<Annonce> getMatchingAds(String subject, String location) {
		return userDAO.getMatchingAds(subject, location);
	}

	
	// UserDAO Getter and Setter
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
}
