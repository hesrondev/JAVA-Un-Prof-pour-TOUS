package com.ingesup.labojava.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PLANNING")
public class Planning {
	
	
	Long id;
	User user;
	
	// Liste d'événement
	
	private Set<CourseEvent> courses = new HashSet<CourseEvent>();

	public Planning() {
		
	}
	
	// Constructor
	
	public Planning(User p) {
		user = p;
	}
	
	// Ajouter un cours
	
	public void addCourse(CourseEvent courseEvent) {
		courseEvent.setPlanning(this);
		courses.add(courseEvent);
	}
	
	// Getters and Setters
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PLANNING_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "planning", targetEntity = CourseEvent.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<CourseEvent> getCourses() {
		return courses;
	}
	
	public void setCourses(Set<CourseEvent> courses) {
		this.courses = courses;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
