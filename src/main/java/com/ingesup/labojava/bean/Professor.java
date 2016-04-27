package com.ingesup.labojava.bean;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "PROFESSOR")
public class Professor extends User {
	
	
	private int experience;
	
	// Constructor
	
	public Professor() {
		super();
		type = "PROFESSOR";
		planning = new Planning(this);
	}
	
	
	@Override
	public void addCourseEvent(CourseEvent e) {
		planning.addCourse(e);
	}
	
	// Getters and Setters
	
	
	
	
	public int getExperience() {
		return experience;
	}
	
	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String toString() {

		return type +"\n" + super.toString();
	}
}
