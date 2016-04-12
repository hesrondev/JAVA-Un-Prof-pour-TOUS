package com.ingesup.labojava.factory;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.form.AnnonceFormBean;

public class AnnonceFactory {
	
	
	// Annonce VIDE
	
	public Annonce createAnnonce() {
		return new Annonce();
	}
	
	// Annonce à partir du BEAN du formulaire
	
	public Annonce createAnnonce(final AnnonceFormBean adFormBean) {
		Annonce ad = new Annonce();
		
		ad.setTitle(adFormBean.getTitle());
		ad.setSubject(adFormBean.getSubject());
		ad.setLevel(adFormBean.getLevel());
		ad.setLocation(adFormBean.getLocation());
		ad.setCostPerHour(adFormBean.getCostPerHour());
		ad.setDescription(adFormBean.getDescription());
		
		return ad;
	}

}
