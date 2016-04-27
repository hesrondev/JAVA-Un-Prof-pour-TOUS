package com.ingesup.labojava.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student extends User{
	
	public Student() {
		super();
		type = "STUDENT";
		planning = new Planning(this);
	}
	
	public String toString() {
		
		return type + "\n" + super.toString();
	}


}
