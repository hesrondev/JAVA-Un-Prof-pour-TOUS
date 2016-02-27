package com.ingesup.labojava.dao;

import java.util.List;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.bean.User;

public interface UserDAO {
	
	
	public void addUser(User user);
	public User updateUser(User user);
	public List<User> getAllUsers();
	public User getUser(String email, String pass);
	public User getUser(Long userID);
	public void removeUser(Long userID);
	
	public List<Annonce> getAllAds();
	public List<Annonce> getAllAdsByUser(Long userID);
	
	public List<Student> getAllStudents();
	public List<Professor> getAllProfessors();
	

}
