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
@Table(name="ANNONCE")
public class Annonce{
	
	private Long id;
	private String title;
	private double costPerHour;
	private String description;
	private String location;
	private String subject;
	private User user;
	
	/*
	 * Constructor
	 * */
	
	public Annonce() {}
	
	
	/*
	 * ToString
	 * */
	public String toString() {
		
		return "[Annonce]\nID: " + id + "\nTitle: " +title + "\nSubject: " + subject  + "\nlocation:" +location 
				+ "Prix/h: " + costPerHour + " €/h" + "\nDescription: " + 
		description;
	}
	
	/*
	 * Getters and setters
	 * */  
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ANNONCE_ID")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="COST_PER_HOUR")
	public double getCostPerHour() {
		return costPerHour;
	}


	public void setCostPerHour(double costPerHour) {
		this.costPerHour = costPerHour;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="LOCATION")
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name="SUBJECT")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
	
	
	

}
