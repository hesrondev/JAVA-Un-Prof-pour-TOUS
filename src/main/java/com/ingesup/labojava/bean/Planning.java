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
	
	
	// ID
	Long id;
	
	// Propriétaire
	
	Professor professor;
	
	// Liste d'événement
	
	private Set<CourseEvent> courses = new HashSet<CourseEvent>();

	// 
	
	public Planning() {
		
	}
	
	// Constructor
	
	public Planning(Professor p) {
		professor = p;
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
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	
	
	

}
