package com.ingesup.labojava.form;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
	
	// Photo de profil
	
		MultipartFile profilePictureFile;

		
		
		// Getters and Setters 
		
		public MultipartFile getProfilePictureFile() {
			return profilePictureFile;
		}

		public void setProfilePictureFile(MultipartFile profilePictureFile) {
			this.profilePictureFile = profilePictureFile;
		}
		
		
		
}
