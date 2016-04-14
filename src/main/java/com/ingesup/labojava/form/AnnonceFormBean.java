package com.ingesup.labojava.form;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class AnnonceFormBean {
	
	
	@NotEmpty(message="TITRE obligatoire!")
	private String title;
	
	private double costPerHour;
	
	@NotEmpty(message="DESCRIPTION obligatoire!")
	private String description;
	
	@NotEmpty(message="LIEU obligatoire!")
	private String location;
	
	@NotEmpty(message="MATIERE obligatoire!")
	private String subject;
	
	@NotEmpty(message="NIVEAU obligatoire!")
	private String level;
	
	private boolean showPhoneNumber;

	// filtre
	private List<Filter> filters = new ArrayList<Filter>();
	
	
	
	// Constructeur
	
	public AnnonceFormBean() {
		
	}
	
	/* Mise à jour des status des filtres
	 * On recherche l'élément dans la liste
	 * Si on le trouve, on le supprime sinon on l'ajoute
	 */
	
	// Status
	
	public void updateFilter(String category, String value) {
		
		int index = -1;
		
		// recherche du filtre
		
		for (int i = 0; i < filters.size(); i++) {
			if (filters.get(i).getValue().equals(value))
				index = i;
		}
		
		if (index != -1)
			filters.remove(index);
		else
		{

			FilterCategory fc;
			
			if ("status".equals(category))
				fc = FilterCategory.STATUS;
			else if ("subject".equals(category))
				fc = FilterCategory.SUBJECT;
			else if ("level".equals(category))
				fc = FilterCategory.LEVEL;
			else if ("location".equals(category))
				fc = FilterCategory.LOCATION;
			else {
				System.err.println("Filter category dont match");

				// par défaut on met la catégorie location
				fc = FilterCategory.LOCATION;
			}
				
			
			filters.add(new Filter(fc, value));
		}
	}
	
	
	/* 
	 * Getters et Setters
	 * */
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getCostPerHour() {
		return costPerHour;
	}
	public void setCostPerHour(double costPerHour) {
		this.costPerHour = costPerHour;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public boolean isShowPhoneNumber() {
		return showPhoneNumber;
	}

	public void setShowPhoneNumber(boolean showPhoneNumber) {
		this.showPhoneNumber = showPhoneNumber;
	}
	

}
