package com.ingesup.labojava.service;

import java.util.List;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.FriendRequest;
import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.AnnonceFormBean;

public interface UserService {
	
	public void addUser(User user);
	public User updateUser(User user);
	public List<User> getAllUsers();
	public User getUser(String email, String pass);
	public User getUser(Long userID);
	public void removeUser(Long userID);
	
	public List<Student> getAllStudents();
	public List<Professor> getAllProfessors();
	
	
	public Annonce updateAnnonce(Annonce annonce);
	public Annonce getAdById(Long ID);
	public List<Annonce> getAllAds();
	public List<Annonce> getAllAdsByUser(Long userID);
	public List<Annonce> getMatchingAds(String subject, String location);
	public List<Annonce> getFilteredAds(AnnonceFormBean afb);
	
	public FriendRequest getFriendRequest(Long reqID);
	public void removeFriendRequest(FriendRequest fRequest);

}
