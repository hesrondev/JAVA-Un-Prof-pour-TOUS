package com.ingesup.labojava.form;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class PublicationFormBean {

		
		@NotEmpty(message="DESCRIPTION obligatoire!")
		private String description;
		
		// Constructeur
		
		public PublicationFormBean() {
			
		}		
		
		/* 
		 * Getters et Setters
		 * */
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

}
