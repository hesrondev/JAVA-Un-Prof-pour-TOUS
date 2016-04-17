package com.ingesup.labojava.form;

public class UserFormBean {
	
	
	private String fullName;
	
	
	public UserFormBean() {
		
	}
	
	public UserFormBean(String name) {
		this.fullName = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String name) {
		this.fullName = name;
	}
	
	
	
}
