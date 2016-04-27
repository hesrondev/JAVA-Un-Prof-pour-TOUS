package com.ingesup.labojava.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
	
	private Set<AnnonceApplication> applications = new HashSet<AnnonceApplication>();
	
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
	
	/* R�cup�re une candidature */
	public AnnonceApplication getAnnonceApplication(AnnonceApplication ap) {
		
		for (Iterator<AnnonceApplication> iterator = applications.iterator(); iterator.hasNext();) {
		    AnnonceApplication a = iterator.next();
		    if (ap.getId() == a.getId())
		    	return a;
		}
		
		return null;
	}
	
	/* V�rifie qu'on a pas d�j� envoy� ue candidature*/
	
	public boolean hasAlreadyApplied(AnnonceApplication ap) {
		
		for (Iterator<AnnonceApplication> iterator = applications.iterator(); iterator.hasNext();) {
		    AnnonceApplication a = iterator.next();
		    if (ap.getEmail().equals(a.getEmail()))
		    	return true;
		}
		
		return false;
	}
	
	
	public int applicationsCount() {
		return applications.size();
	}
	
	
	/*
	 * ToString
	 * */
	public String toString() {
		
		return "[Annonce]\nID: " + id + "\nTitle: " +title + "\nSubject: " + subject  + "\nlocation:" +location 
				+ "Prix/h: " + costPerHour + " �/h" + "\nDescription: " + 
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
	public Set<AnnonceApplication> getApplications() {
		return applications;
	}


	public void setApplications(Set<AnnonceApplication> applications) {
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

	
	
	// EQUALS & HASH METHODS
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Annonce other = (Annonce) obj;
		
		if (id == other.id)
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
