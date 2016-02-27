package com.ingesup.labojava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.dao.UserDAO;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	
	// User DAO
	
	private UserDAO userDAO;
	
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	public User getUser(String email, String pass) {
		return userDAO.getUser(email, pass);
	}
	public User getUser(Long userID) {
		return userDAO.getUser(userID);
	}
	public void removeUser(Long userID) {
		userDAO.removeUser(userID);
	}
	
	public List<Annonce> getAllAds() {
		return userDAO.getAllAds();
	}
	public List<Annonce> getAllAdsByUser(Long userID) {
		return userDAO.getAllAdsByUser(userID);
	}
	
	public List<Student> getAllStudents() {
		return userDAO.getAllStudents();
	}
	public List<Professor> getAllProfessors(){
		return userDAO.getAllProfessors();
	}
	
	
	// UserDAO Getter and Setter
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
