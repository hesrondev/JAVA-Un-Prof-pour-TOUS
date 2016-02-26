package com.ingesup.labojava.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROFESSOR")
public class Professor implements Serializable{
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	private static final long serialVersionUID = 1L;
	
	public Professor() {}
	
	// toString
	public String toString() {
		
		return "PROFESSEUR\nID : " +id+ "\nPRENOM : " +firstName+
				"\nNOM : " +lastName+ "\nEMAIL : " +email+
				"\nPASS : " +password;
	}
	
	// Getters and Setters
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROFESSOR_ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="PROFESSOR_FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="PROFESSOR_LASTNAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="PROFESSOR_EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="PROFESSOR_PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
