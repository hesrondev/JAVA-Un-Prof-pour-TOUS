package com.ingesup.labojava.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	private Calendar startDate;
	private Calendar endDate;
	private String city;
	private String comment;
	
	
	// Planning dont fait parti l'événement

	Planning planning;

	public CourseEvent() {

	}
	
	public CourseEvent(Planning planning) {
		this.planning = planning;
	}

	public CourseEvent(String title, String sName, Calendar sdate, Calendar eDate, String city,
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
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE d MMM yyyy à HH:mm");
		String str = dateFormat.format(startDate.getTime());
		
		return str;
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

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
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
