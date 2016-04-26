package com.ingesup.labojava.form;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.ingesup.labojava.bean.CourseEvent;

public class CourseEventFormBean {
	
	
	/* Bean Form d'un évenement du calendrier */
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String studentName;
	
	@NotEmpty
	private int startHour;
	
	@NotEmpty
	private int startMinutes;
	
	@NotEmpty
	private int startDay;
	
	@NotEmpty
	private int startMonth;
	
	@NotEmpty
	private int startYear;
	
	@NotEmpty
	private int endHour;
	
	@NotEmpty
	private int endMinutes;
	
	@NotEmpty
	private int endDay;
	
	@NotEmpty
	private int endMonth;
	
	@NotEmpty
	private int endYear;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String comment;
	
	
	
	// Constructeurs 
	
	public CourseEventFormBean() {
		
	}
	
	@SuppressWarnings("deprecation")
	public CourseEvent createEvent() {
		
		Date startDate = new Date();
		Date endDate = new Date();
		
		startDate.setHours(startHour);
		startDate.setMinutes(startMinutes);
		startDate.setDate(startDay);
		startDate.setMonth(startMonth);
		startDate.setYear(startYear);
		
		endDate.setHours(endHour);
		endDate.setMinutes(endMinutes);
		endDate.setDate(endDay);
		endDate.setMonth(endMonth);
		endDate.setYear(endYear);
		
		return new CourseEvent(title, studentName, startDate, endDate, city, comment);
		
	}

	
	// Getters and Setters
	
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

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getStartMinutes() {
		return startMinutes;
	}

	public void setStartMinutes(int startMinutes) {
		this.startMinutes = startMinutes;
	}

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	public int getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public int getEndMinutes() {
		return endMinutes;
	}

	public void setEndMinutes(int endMinutes) {
		this.endMinutes = endMinutes;
	}

	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	
	
	
	
	
	

}
