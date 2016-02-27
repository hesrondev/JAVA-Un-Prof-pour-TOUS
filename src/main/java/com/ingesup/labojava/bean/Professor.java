package com.ingesup.labojava.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESSOR")
public class Professor extends User {
	
	
	
	public Professor() {
		
	}

	public String toString() {

		return "[PROFESSOR]\n" + super.toString();
	}
}
