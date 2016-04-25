package com.ingesup.labojava.form;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class FormMaps {

	// Liste de toutes les MAP utilisées dans nos formulaires

	/* MAP de matières ici... */

	private Map<String, String> subjectsMap = new LinkedHashMap<String, String>();
	private Map<String, String> jobsMap = new LinkedHashMap<String, String>();
	private Map<String, String> experiencesMap = new LinkedHashMap<String, String>();
	private Map<String, String> citiesMap = new LinkedHashMap<String, String>();
	private Map<String, String> countriesMap = new LinkedHashMap<String, String>();
	private Map<String, String> departementsMap = new LinkedHashMap<String, String>();
	private Map<String, String> levelsMap = new LinkedHashMap<String, String>();
	
	BufferedReader lecteurAvecBuffer = null;
    String ligne;
	public FormMaps() {

		// On ajout quelques valeurs dans la MAP pour exemple

		subjectsMap.put("maths", "Math�matiques");
		subjectsMap.put("physique", "Physique Chimie");
		subjectsMap.put("francais", "Fran�ais");
		subjectsMap.put("philo", "philosophie");
		
		jobsMap.put("étudiant", "étudiant");
		jobsMap.put("ingénieur", "ingénieur");
		
		experiencesMap.put("moins de 2 ans", "moins de 2 ans");
		experiencesMap.put("entre 2 et 5 ans", "entre 2 et 5 ans");
		experiencesMap.put("plus de 5 ans", "plus de 5 ans");
		experiencesMap.put("plus de 10 ans", "plus de 10 ans");
		
		citiesMap.put("Paris", "Paris");
		citiesMap.put("Versailles", "Versailles");
		citiesMap.put("Lille", "Lille");
		citiesMap.put("Lyon", "Lyon");
		citiesMap.put("Marseille", "Marseille");
		
		countriesMap.put("Fr", "France");
		
		departementsMap.put("75", "75");
		departementsMap.put("78", "78");
		departementsMap.put("13", "13");
		departementsMap.put("59", "59");
		departementsMap.put("69", "69");
		
		levelsMap.put("Primaire", "Primaire");
		levelsMap.put("Coll�ge", "Coll�ge");
		levelsMap.put("Lyc�e", "Lyc�e");
		levelsMap.put("Universit�", "Universit�");
		levelsMap.put("D�butant", "D�butant");
		levelsMap.put("Interm�diaire", "Interm�diaire");
		levelsMap.put("Avanc�", "Avanc�");
		 //on remplit la map professions � partir du fichier du m�me nom
		/*try
	      {
			lecteurAvecBuffer = new BufferedReader(new FileReader("professions"));
	      }
	    catch(FileNotFoundException exc)
	      {
	    	System.out.println("Erreur d'ouverture");
	      }

			while ((ligne = lecteurAvecBuffer.readLine()) != null)
			      System.out.println(ligne);
			lecteurAvecBuffer.close(); */

		// Après ça, je crée le getteur et le setteur de cette MAP
		// Cette MAP sera alors injecté par le controleur par la méthode 'addMaps' ---> puis utilisé dans la JSP
		// ALLONS DANS LA JSP
	}
	
	
	
	// Getters and Setters
	
	public Map<String, String> getJobsMap() {
		return jobsMap;
	}

	public void setJobsMap(Map<String, String> jobsMap) {
		this.jobsMap = jobsMap;
	}

	public Map<String, String> getExperiencesMap() {
		return experiencesMap;
	}

	public void setExperiencesMap(Map<String, String> experiencesMap) {
		this.experiencesMap = experiencesMap;
	}

	public Map<String, String> getCitiesMap() {
		return citiesMap;
	}

	public void setCitiesMap(Map<String, String> citiesMap) {
		this.citiesMap = citiesMap;
	}

	public Map<String, String> getCountriesMap() {
		return countriesMap;
	}

	public void setCountriesMap(Map<String, String> countriesMap) {
		this.countriesMap = countriesMap;
	}

	public Map<String, String> getDepartementsMap() {
		return departementsMap;
	}

	public void setDepartementsMap(Map<String, String> departementsMap) {
		this.departementsMap = departementsMap;
	}

	public Map<String, String> getLevelsMap() {
		return levelsMap;
	}

	public void setLevelsMap(Map<String, String> levelsMap) {
		this.levelsMap = levelsMap;
	}

	public Map<String, String> getSubjectsMap() {
		return subjectsMap;
	}

	public void setSubjectsMap(Map<String, String> subjectsMap) {
		this.subjectsMap = subjectsMap;
	}
	
	
}
