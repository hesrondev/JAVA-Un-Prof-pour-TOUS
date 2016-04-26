package com.ingesup.labojava.factory;

import com.ingesup.labojava.bean.Publication;
import com.ingesup.labojava.form.PublicationFormBean;

public class PublicationFactory {
	// Publication VIDE
		
		public Publication createPublication() {
			return new Publication();
		}
		
		// Publication à partir du BEAN du formulaire
		
		public Publication createPublication(final PublicationFormBean publiFormBean) {
			Publication publi = new Publication();
		
			publi .setDescription(publiFormBean.getDescription());
			
			return publi ;
		}

}
