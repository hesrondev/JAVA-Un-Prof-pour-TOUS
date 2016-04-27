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

	// Liste de toutes les MAP utilisÃ©es dans nos formulaires

	/* MAP de matiÃ¨res ici... */

	private Map<String, String> subjectsMap = new LinkedHashMap<String, String>();
	private Map<String, String> jobsMap = new LinkedHashMap<String, String>();
	private Map<String, String> experiencesMap = new LinkedHashMap<String, String>();
	private Map<String, String> citiesMap = new LinkedHashMap<String, String>();
	private Map<String, String> countriesMap = new LinkedHashMap<String, String>();
	//private Map<String, String> departementsMap = new LinkedHashMap<String, String>();
	private Map<String, String> levelsMap = new LinkedHashMap<String, String>();
	
	//map contenant les villes par département
	private Map<String, String> parisMap = new LinkedHashMap<String, String>();
	private Map<String, String> seineEtMarneMap = new LinkedHashMap<String, String>();
	private Map<String, String> yvelinesMap = new LinkedHashMap<String, String>();
	private Map<String, String> essoneMap = new LinkedHashMap<String, String>();
	private Map<String, String> heutsDeSeineMap = new LinkedHashMap<String, String>();
	private Map<String, String> seineSaintDenisMap = new LinkedHashMap<String, String>();
	private Map<String, String> valDeMarneMap = new LinkedHashMap<String, String>();
	private Map<String, String> valDoiseMap = new LinkedHashMap<String, String>();
	
	// Mois
	
	private Map<String, String> months = new LinkedHashMap<String, String>();
	
	BufferedReader lecteurAvecBuffer = null;
    String ligne;
	public FormMaps() {
		
		// Les mois
		
		months.put("0", "Janvier");
		months.put("1", "FÃ©vrier");
		months.put("2", "Mars");
		months.put("3", "Avril");
		months.put("4", "Mai");
		months.put("5", "Juin");
		months.put("6", "Juillet");
		months.put("7", "AoÃ»t");
		months.put("8", "Septembre");
		months.put("9", "Octobre");
		months.put("10", "Novembre");
		months.put("11", "DÃ©cembre");
		
		
		
		// On ajout quelques valeurs dans la MAP pour exemple

		subjectsMap.put("maths", "Mathï¿½matiques");
		subjectsMap.put("physique", "Physique Chimie");
		subjectsMap.put("francais", "Franï¿½ais");
		subjectsMap.put("philo", "philosophie");
		
		jobsMap.put("Ã©tudiant", "Ã©tudiant");
		jobsMap.put("ingÃ©nieur", "ingÃ©nieur");
		
		experiencesMap.put("moins de 2 ans", "moins de 2 ans");
		experiencesMap.put("entre 2 et 5 ans", "entre 2 et 5 ans");
		experiencesMap.put("plus de 5 ans", "plus de 5 ans");
		experiencesMap.put("plus de 10 ans", "plus de 10 ans");
		
		citiesMap.put("Paris", "Paris - 75");
		citiesMap.put("Versailles", "Versailles - 78");
		citiesMap.put("La Défense", "La Défense - 92");
		citiesMap.put("Colombes", "Colombes - 92");
		citiesMap.put("Lyon", "Lyon - 69");
		
		countriesMap.put("Fr", "France");
		
		//Départements
		/*departementsMap.put("75", "75 - Paris");
		departementsMap.put("77", "77 - Seine et Marne");
		departementsMap.put("78", "78 - Yvelines");
		departementsMap.put("91", "91 - Essone");
		departementsMap.put("92", "92 - Hauts De Seine");		
		departementsMap.put("93", "93 - Seine Saint Denis");
		departementsMap.put("94", "94 - Val de Marne");
		departementsMap.put("95", "95 - Val d'Oise");  */
		
		//Villes par départements
		
		
		levelsMap.put("Primaire", "Primaire");
		levelsMap.put("Collège", "Collège");
		levelsMap.put("Lycée", "Lycée");
		levelsMap.put("Universitée", "Universitée");
		levelsMap.put("Débutant", "Débutant");
		levelsMap.put("Intermédiaire", "Intermédiaire");
		levelsMap.put("Avancé", "Avancé");
		 //on remplit la map professions ï¿½ partir du fichier du mï¿½me nom
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

		// AprÃ¨s Ã§a, je crÃ©e le getteur et le setteur de cette MAP
		// Cette MAP sera alors injectÃ© par le controleur par la mÃ©thode 'addMaps' ---> puis utilisÃ© dans la JSP
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
/*
	public Map<String, String> getDepartementsMap() {
		return departementsMap;
	}

	public void setDepartementsMap(Map<String, String> departementsMap) {
		this.departementsMap = departementsMap;
	}
	*/

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



	public Map<String, String> getMonths() {
		return months;
	}



	public void setMonths(Map<String, String> months) {
		this.months = months;
	}
	
	
	
}
