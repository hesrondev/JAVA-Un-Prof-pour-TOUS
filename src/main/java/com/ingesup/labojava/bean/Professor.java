package com.ingesup.labojava.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "PROFESSOR")
public class Professor extends User {
	
	
	private int experience;
	
	/* Collection */
	
	private Planning planning;
	
	
	// Constructor
	
	public Professor() {
		super();
		type = "PROFESSOR";
		planning = new Planning(this);
	}
	
	// Ajouter un planning
	
	public void addPlanning(Planning planning) {
		this.planning = planning;
	}
	
	public void addCourseEvent(CourseEvent e) {
		planning.addCourse(e);
	}
	
	
	// Getters and Setters
	
	
	
	public int getExperience() {
		return experience;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "professor", targetEntity = Planning.class, cascade = CascadeType.ALL)
	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String toString() {

		return type +"\n" + super.toString();
	}
}
