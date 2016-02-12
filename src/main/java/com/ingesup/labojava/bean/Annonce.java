package com.ingesup.labojava.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ANNONCE")
public class Annonce {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ANNONCE_ID")
	private Long id;
	private String title;
	private String description;
	private String location;
	private String subject;
	
	// user
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//private Student student;
	
	
	// Constructor
	public Annonce() {}
	
	
	// Méthode toString
	public String toString() {
		
		return "Annonce\nID: " + id + "\nTitle: " +title + "\nSubject: " + subject + "\nDescription: " + 
		description + "\nlocation:" +location;
	}
	
	// Getters and setters 
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	/*
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	*/
	
	
	

}
