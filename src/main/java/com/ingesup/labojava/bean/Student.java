package com.ingesup.labojava.bean;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="STUDENT")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_ID")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	// Liste d'annonces	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy="ANNONCE_ID")
	//private List<Annonce> listAnnonces;
	
	
	// toString
	
	public String toString() {
		
		return "ELEVE\nID : " +id+ "\nPRENOM : " +firstName+
				"\nNOM : " +lastName+ "\nEMAIL : " +email+
				"\nPASS : " +password;
	}
	
	// Getters and Setters
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	public List<Annonce> getListAnnonces() {
		return listAnnonces;
	}

	public void setListAnnonces(List<Annonce> listAnnonces) {
		this.listAnnonces = listAnnonces;
	}*/

}
