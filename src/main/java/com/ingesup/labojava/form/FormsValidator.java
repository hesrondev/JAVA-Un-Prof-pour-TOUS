package com.ingesup.labojava.form;

public class FormsValidator {
	
	// M�thode qui v�rifie la coh�rence des informations du bean � l'inscription
	public boolean isValidInscriptionForm(InscriptionFormBean ifb) {
		
		// Si mots de passe identiques
		if (!ifb.getPassword().equals(ifb.getRePassword()))
			return false;
		
		return true;
	}
}
