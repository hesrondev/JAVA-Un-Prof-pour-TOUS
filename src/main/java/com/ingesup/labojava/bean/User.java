package com.ingesup.labojava.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USER")
public abstract class User {

	protected Long id;
	protected String type;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;

	// Collections

	protected List<Annonce> annonces = new ArrayList<Annonce>();

	// toString
	public String toString() {

		return "ID : " + id + "\nFIRSTNAME : " + firstName + "\nLASTNAME : " + lastName + "\nEMAIL : " + email
				+ "\nPASSWORD : " + password;
	}
	
	
	// Add a new annonce to the list
	public void addAnnonce(Annonce ad) {
		ad.setUser(this);
		annonces.add(ad);
	}
	
	/*
	 * Getters and Setters
	 * */
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="LASTNAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy="user", targetEntity=Annonce.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
