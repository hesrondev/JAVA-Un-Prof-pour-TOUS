package com.ingesup.labojava.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ANNONCE_APPLICATION")
public class AnnonceApplication {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String message;
	private Annonce annonce;

	/* Constructors */

	public AnnonceApplication() {
		firstName = "";
		lastName = "";
		email = "";
		phoneNumber = "";
		message = "";
	}

	public AnnonceApplication(Annonce annonce, String fname, String lname, String em, String phone, String msg) {
		this.annonce = annonce;
		firstName = fname;
		lastName = lname;
		email = em;
		phoneNumber = phone;
		message = msg;
	}

	/* Getters and Setters */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ANNONCE_APPLICATION_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USER_FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "USER_LASTNAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "USER_EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "USER_PHONE_NUMBER")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "MESSAGE")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ANNONCE_ID", nullable = false)
	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	// EQUALS & HASH METHODS

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		AnnonceApplication other = (AnnonceApplication) obj;
		
		if (id == other.id && email == other.email)
			return true;
		
		else
			return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
