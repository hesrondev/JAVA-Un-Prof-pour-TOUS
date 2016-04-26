package com.ingesup.labojava.bean;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PUBLICATION")
public class Publication {

		private Long id;
		private String description;
		private Date date;

		// Owner
		private User user;
		
		
		/*
		 * Constructor
		 * */
		
		public Publication() {
			date = new Date();
		}
		
		/*
		 * Get date to string format
		 * */
		
		public String toStringDate() {
			DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
			return dateFormat.format(date);
		}
	
		/*
		 * ToString
		 * */
		public String toString() {
			
			return "[Publication]\nID: " + id + "\nDescription: " + description;
		}
		
		
		/*
		 * Getters and setters
		 * */  
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="PUBLICATION_ID")
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}

		@Column(name="DESCRIPTION")
		public String getDescription() {
			return description;
		}
		
		public void setDescription(String description) {
			this.description = description;
		}

		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "USER_ID", nullable = false)
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		@Column(name="DATE")
		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		
		
		// EQUALS & HASH METHODS
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;

			Publication other = (Publication) obj;
			
			if (id == other.id)
				return true;
			
			else
				return false;
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}

}
