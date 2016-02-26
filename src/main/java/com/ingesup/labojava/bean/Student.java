package com.ingesup.labojava.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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

import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name="STUDENT")
public class Student implements Serializable{
	
	
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private List<Annonce> listAnnonces = new ArrayList<Annonce>();
	
	private static final long serialVersionUID = 1L;
	
	public Student() {	}
	
	// toString	
	public String toString() {
		
		return "ELEVE\nID : " +id+ "\nPRENOM : " +firstName+
				"\nNOM : " +lastName+ "\nEMAIL : " +email+
				"\nPASS : " +password;
	}
	
	// Ajout d'une annonce
	
	public boolean addAnnonce(Annonce ad) {
		
		ad.setStudent(this);			// ajout de l'utilisateur
		return listAnnonces.add(ad);
	}
	
	// Getters and Setters
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_ID")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="STUDENT_FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="STUDENT_LASTNAME")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="STUDENT_EMAIL")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="STUDENT_PASSWORD")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(mappedBy="student", targetEntity=Annonce.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Annonce> getListAnnonces() {
		return listAnnonces;
	}

	public void setListAnnonces(List<Annonce> listAnnonces) {
		this.listAnnonces = listAnnonces;
	}

}
