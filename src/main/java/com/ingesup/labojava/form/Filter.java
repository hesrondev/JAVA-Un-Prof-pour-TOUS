package com.ingesup.labojava.form;

public class Filter {
	
	private String value;
	private FilterCategory eCategory;
	private int counter;
	
	public Filter(FilterCategory fc, String value) {
		
		this.eCategory = fc;
		this.value = value;
		this.counter = 1;
		
	}
	
	// increment counter
	
	public void counterPlus() {
		this.counter++;
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

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
