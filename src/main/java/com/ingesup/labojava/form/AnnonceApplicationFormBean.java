package com.ingesup.labojava.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class AnnonceApplicationFormBean {
	
	
	@NotEmpty(message="PRENOM obligatoire!")
	private String firstName;
	
	@NotEmpty(message="NOM obligatoire!")
	private String lastName;
	
	@NotEmpty(message="EMAIL obligatoire!")
	@Email(message="Vérifiez le format de l'adresse mail")
	private String email;
	
	private String phoneNumber;
	
	private String message;
	
	public AnnonceApplicationFormBean() {
		
		firstName = "";
		lastName = "";
		email = "";
		phoneNumber = "";
		message = "";
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
