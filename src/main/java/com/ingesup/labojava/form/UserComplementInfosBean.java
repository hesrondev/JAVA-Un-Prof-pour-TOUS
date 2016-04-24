package com.ingesup.labojava.form;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.hibernate.validator.constraints.NotEmpty;

import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.User;

public class UserComplementInfosBean {

	/*@NotEmpty(message="Date de naissance obligatoire!")
	private Date birthDate;*/
	
	@NotEmpty(message="Date de naissance obligatoire!")
	private int birthDay;
	
	@NotEmpty(message="Date de naissance obligatoire!")
	private int birthMonth;
	
	@NotEmpty(message="Date de naissance obligatoire!")
	private int birthYear;
	
	@NotEmpty(message="Département obligatoire!")
	private String departement;

	@NotEmpty(message="Ville obligatoire!")
	private String city;
	
	@NotEmpty(message="Pays obligatoire!")
	private String country;
	
	@NotEmpty(message="Profession obligatoire!")
	private String profession;
	
	private String phoneNumber;
	
	private String gradeLevel;
	private int experience;
	private String aboutMe;
	
	
	
	
	// Constructor by default
	
	public UserComplementInfosBean() {
		
	}
	
	

	/* Complete User infos */

	public User completeInfos(User u) {

		if (u != null) {
			u.setBirthDay(birthDay);
			u.setBirthMonth(birthMonth);
			u.setBirthYear(birthYear);
			u.setPhoneNumber(phoneNumber);
			u.setCity(city);
			u.setCountry(country);
			u.setProfession(profession);
			u.setGradeLevel(gradeLevel);
			u.setAboutMe(aboutMe);

			if (u.getClass().equals(Professor.class))
				((Professor)u).setExperience(experience);
		}

		return u;
	}

	/*public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}*/

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public int getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

}
