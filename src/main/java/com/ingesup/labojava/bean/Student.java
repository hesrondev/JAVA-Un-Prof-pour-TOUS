package com.ingesup.labojava.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student extends User{
	
	
	public Student() {
		
	}
	
	public String toString() {
		
		return "[STUDENT]\n" + super.toString();
	}


}
