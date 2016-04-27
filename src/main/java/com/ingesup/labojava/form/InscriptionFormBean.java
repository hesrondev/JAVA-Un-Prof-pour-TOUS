package com.ingesup.labojava.form;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class InscriptionFormBean {
	
	@NotEmpty(message="PRENOM obligatoire!")
	private String firstName;
	
	@NotEmpty(message="NOM obligatoire!")
	private String lastName;
	
	@NotEmpty(message="EMAIL obligatoire!")
	@Email(message="Vérifiez le format de l'adresse mail")
	private String email;
	
	@NotEmpty(message="MOT DE PASSE obligatoire!")
	@Size(min=6, message="Le mot de passe doit contenir minimum 6 caractères")
	private String password;
	
	@NotEmpty(message="MOT DE PASSE obligatoire!")
	@Size(min=6, message="Le mot de passe doit contenir minimum 6 caractères")
	private String rePassword;
	
	@NotEmpty(message="STATUT obligatoire!")
	private String status;
	
	@NotEmpty(message="Genre Obligatoire!")
	private String gender;
	
	//Getters and Setters
	
	
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
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
