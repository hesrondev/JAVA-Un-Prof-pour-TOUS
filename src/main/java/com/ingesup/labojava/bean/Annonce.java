package com.ingesup.labojava.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
public class Annonce{
	
	private Long id;
	private String title;
	private double costPerHour;
	private String description;
	private String location;
	private String subject;
	private String level;
	private Date date;
	private boolean showPhoneNumber;

	// Owner
	private User user;
	
	// Collections
	
	private List<AnnonceApplication> applications = new ArrayList<AnnonceApplication>();
	
	/*
	 * Constructor
	 * */
	
	public Annonce() {
		date = new Date();
	}
	
	/*
	 * Get date to string format
	 * */
	
	public String toStringDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		return dateFormat.format(date);
	}
	
	/*
	 * ToString
	 * */
	public String toString() {
		
		return "[Annonce]\nID: " + id + "\nTitle: " +title + "\nSubject: " + subject  + "\nlocation:" +location 
				+ "Prix/h: " + costPerHour + " €/h" + "\nDescription: " + 
		description;
	}
	
	/**
	 * ADD application
	 * */
	
	public void addApplication(AnnonceApplication annonceApplication) {
		applications.add(annonceApplication);
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
	
	@Column(name="LEVEL")
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy="annonce", targetEntity=AnnonceApplication.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public List<AnnonceApplication> getApplications() {
		return applications;
	}


	public void setApplications(List<AnnonceApplication> applications) {
		this.applications = applications;
	}
	
	@Column(name="SHOW_PHONE")
	public boolean isShowPhoneNumber() {
		return showPhoneNumber;
	}
	
	public void setShowPhoneNumber(boolean showPhoneNumber) {
		this.showPhoneNumber = showPhoneNumber;
	}
	
	@Column(name="DATE")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
