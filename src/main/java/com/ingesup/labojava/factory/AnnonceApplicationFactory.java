package com.ingesup.labojava.factory;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.AnnonceApplication;
import com.ingesup.labojava.form.AnnonceApplicationFormBean;

public class AnnonceApplicationFactory {
	
	// AnnonceApplication "candidature" VIDE
	
		public AnnonceApplication createAnnonce() {
			return new AnnonceApplication();
		}
		
		// Annonce à partir du BEAN du formulaire
		
		public AnnonceApplication createAnnonceApplication(Annonce annonce, final AnnonceApplicationFormBean apb) {
			
			return new AnnonceApplication(annonce, apb.getFirstName(), apb.getLastName(), apb.getEmail(), apb.getPhoneNumber(), apb.getMessage());
		}

}
