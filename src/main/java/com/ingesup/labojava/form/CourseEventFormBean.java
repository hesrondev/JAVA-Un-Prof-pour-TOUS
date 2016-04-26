package com.ingesup.labojava.form;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


import org.hibernate.validator.constraints.NotEmpty;

import com.ingesup.labojava.bean.CourseEvent;

public class CourseEventFormBean {
	
	
	/* Bean Form d'un évenement du calendrier */
	
	@NotEmpty(message="TITRE obligatoire!")
	private String title;
	
	@NotEmpty(message="NOM_ETUDIANT obligatoire!")
	private String studentName;
	
	private int startHour;
	
	private int startMinutes;
	
	private int startDay;
	
	private int startMonth;
	
	private int startYear;
	
	private int endHour;
	
	private int endMinutes;
	
	private int endDay;
	
	private int endMonth;
	
	private int endYear;
	
	@NotEmpty(message="VILLE obligatoire!")
	private String city;
	
	@NotEmpty(message="COMMENTAIRE obligatoire!")
	private String comment;
	
	
	
	// Constructeurs 
	
	public CourseEventFormBean() {
		
	}
	
	@SuppressWarnings("deprecation")
	public CourseEvent createEvent() {
		

		Calendar cal = Calendar.getInstance();
		cal.set(startYear, startMonth, startDay, startHour, startMinutes);
		
		Date startDate = cal.getTime();
		
		System.out.println("DEBUT " + startDate.toString());
		
		Calendar cal2 = new GregorianCalendar(endYear, endMonth, endDay);
		cal2.set(Calendar.HOUR, endHour);
		cal2.set(Calendar.MINUTE, endMinutes);
		
		Date endDate = cal2.getTime();
		
		System.out.println("FIN " +endDate.toString());
		
		return new CourseEvent(title, studentName, cal, cal2, city, comment);
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
