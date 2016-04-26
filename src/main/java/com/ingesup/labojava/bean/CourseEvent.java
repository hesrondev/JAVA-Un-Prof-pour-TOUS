package com.ingesup.labojava.bean;

import java.util.Date;

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
@Table(name = "COURSE_EVENT")
public class CourseEvent {

	/* Un point du planning d'un professeur */

	private Long id;
	private String title;
	private String studentName;
	private Date startDate;
	private Date endDate;
	private String city;
	private String comment;

	// Planning dont fait parti l'événement

	Planning planning;

	public CourseEvent() {

	}
	
	public CourseEvent(Planning planning) {
		this.planning = planning;
	}

	public CourseEvent(String title, String sName, Date sdate, Date eDate, String city,
			String comment) {
		this.title = title;
		studentName = sName;
		startDate = sdate;
		endDate = eDate;
		this.city = city;
		this.comment = comment;
	}
	
	
	// Afficher la date au format String
	
	public String toStringDate() {
		
		return "Date à formater";
	}

	// Getters and Setters
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COURSE_EVENT_ID")
	public Long getId() {
		return id;
	}

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PLANNING_ID", nullable = false)
	public Planning getPlanning() {
		return planning;
	}


	public void setPlanning(Planning planning) {
		this.planning = planning;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	// Equals AND hASH

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		CourseEvent other = (CourseEvent) obj;

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
