package com.ingesup.labojava.form;

public class Filter {
	
	private String value;
	private FilterCategory eCategory;
	
	public Filter(FilterCategory fc, String value) {
		
		this.eCategory = fc;
		this.value = value;
		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public FilterCategory geteCategory() {
		return eCategory;
	}

	public void seteCategory(FilterCategory eCategory) {
		this.eCategory = eCategory;
	}

}
