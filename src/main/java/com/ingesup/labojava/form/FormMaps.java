package com.ingesup.labojava.form;
import java.util.LinkedHashMap;
import java.util.Map;

public class FormMaps {

	// Liste de toutes les MAP utilisées dans nos formulaires

	/* MAP de matières ici... */

	private Map<String, String> subjectsMap = new LinkedHashMap<String, String>();

	public FormMaps() {

		// On ajout quelques valeurs dans la MAP pour exemple

		subjectsMap.put("maths", "Mathématiques");
		subjectsMap.put("physique", "Physique Chimie");
		subjectsMap.put("francais", "Français");
		subjectsMap.put("philo", "philosophie");

		// Après ça, je crée le getteur et le setteur de cette MAP
		// Cette MAP sera alors injecté par le controleur par la méthode 'addMaps' ---> puis utilisé dans la JSP
		// ALLONS DANS LA JSP
	}
	
	
	
	// Getters and Setters
	
	public Map<String, String> getSubjectsMap() {
		return subjectsMap;
	}



	public void setSubjectsMap(Map<String, String> subjectsMap) {
		this.subjectsMap = subjectsMap;
	}
	
	
}
