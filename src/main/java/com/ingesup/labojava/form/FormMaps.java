package com.ingesup.labojava.form;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.dom4j.Branch;

public class FormMaps {

	// Liste de toutes les MAP utilisées dans nos formulaires

	/* MAP de matières ici... */

	private Map<String, String> subjectsMap = new LinkedHashMap<String, String>();
	private Map<String, String> jobsMap = new LinkedHashMap<String, String>();
	private Map<String, String> experiencesMap = new LinkedHashMap<String, String>();
	private Map<String, String> citiesMap = new LinkedHashMap<String, String>();
	private Map<String, String> countriesMap = new LinkedHashMap<String, String>();
	//private Map<String, String> departementsMap = new LinkedHashMap<String, String>();
	private Map<String, String> levelsMap = new LinkedHashMap<String, String>();
	
	//map contenant les villes par d�partement
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
		months.put("1", "Février");
		months.put("2", "Mars");
		months.put("3", "Avril");
		months.put("4", "Mai");
		months.put("5", "Juin");
		months.put("6", "Juillet");
		months.put("7", "Août");
		months.put("8", "Septembre");
		months.put("9", "Octobre");
		months.put("10", "Novembre");
		months.put("11", "Décembre");
		
		// Matières
		
		
		subjectsMap = loadMapFromFile("resources/maps/matieres.txt");
	}
	
	
	// Charge Map
	
	private Map<String, String> loadMapFromFile(String path) {
		Map<String, String> loadedMap = new LinkedHashMap<String, String>();
		
		
		//ClassLoader cl = getClass().getClassLoader();
		//File file = new File(cl.getResource(path).getFile());
		// Read the file
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			String line = null;
			
			try {
				while ((line = br.readLine()) != null) {
					
					String[] splited = line.split(":");
					
					loadedMap.put(splited[0], splited[1]);
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return loadedMap;
		
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
