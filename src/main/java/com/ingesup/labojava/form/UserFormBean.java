package com.ingesup.labojava.form;

public class UserFormBean {
	
	
	/**BEAN AVEC UN MINIMUM D'INFORMATIONS SUR L'UTILISATEUR 
	 * ---> UTILISE POUR LA RECHERCHE
	 * ---> ET POUR LES ACTIONS DE SUPPRESSION (PROF - ELEVE)
	 * */
	
	private Long userID;
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

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
	
	
	
	
}
