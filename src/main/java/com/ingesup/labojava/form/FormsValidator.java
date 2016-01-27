package com.ingesup.labojava.form;

public class FormsValidator {
	
	// Méthode qui vérifie la cohérence des informations du bean
	public boolean isValidInscriptionForm(InscriptionFormBean ifb) {
		
		// Si mots de passe identiques
		if (!ifb.getPassword().equals(ifb.getRePassword()))
			return false;
		
		
		return true;
	}
}
