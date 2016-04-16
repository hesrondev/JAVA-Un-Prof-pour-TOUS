package com.ingesup.labojava.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USER")
public abstract class User {

	protected Long id;
	protected String type;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;
	
	protected Date inscriptionDate;
	protected Date birthDate;
	protected String phoneNumber;
	protected String city;
	protected String country;
	protected String level;
	protected String aboutMe;

	// Collections

	protected List<Annonce> annonces = new ArrayList<Annonce>();
	protected Set<User> myFriends = new HashSet<User>();
	protected Set<User> friendOf = new HashSet<User>();
	
	/* Listes des demandes: reçues et envoyées */
	protected List<FriendRequest> friendRequests = new ArrayList<FriendRequest>();
		

	public User() {
		inscriptionDate = new Date();
	}

	// toString
	public String toString() {

		return "ID : " + id + "\nFIRSTNAME : " + firstName + "\nLASTNAME : " + lastName + "\nEMAIL : " + email
				+ "\nPASSWORD : " + password;
	}
	
	/**
	 *  Ajout et suppression des éléments dans les listes */
	
	public void addAnnonce(Annonce ad) {
		annonces.add(ad);
	}
	
	public void addFriendRequest(FriendRequest fRequest) {
		friendRequests.add(fRequest);
	}
	
	public void removeFriendRequest(FriendRequest fReq) {
		
		for (FriendRequest fr : friendRequests) 
			if (fr.equals(fReq))
				friendRequests.remove(fr);
	}
	
	
	/**
	 * PROVISOIRE!!! Supprime la requête envoyée */
	public void removeSentFriendRequest(FriendRequest req) {
		
		for (FriendRequest fr : friendRequests) 
			if (fr.isSent() && fr.getReceiverID() == req.getReceiverID() && fr.getSenderID() == req.getSenderID())
				friendRequests.remove(fr);
	}
	
	// ADD a friend
	
	public void addFriend(User user) {
		myFriends.add(user);
	}
	
	public void addFriendOf(User user) {
		
	}

	public void removeFriend(Long userID) {
		
		for (User fr : myFriends) 
			if (fr.getId() == userID)
				myFriends.remove(fr);
	}
	
	/*
	 * Getters and Setters
	 * */
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="LASTNAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/* LIST of annonces */

	@OneToMany(mappedBy="user", targetEntity=Annonce.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}
	
	@Column(name="USER_TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="INSCRIPTION_DATE")
	public Date getInscriptionDate() {
		return inscriptionDate;
	}


	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	@Column(name="BIRTH_DATE")
	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name="PHONE_NUMBER")
	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name="CITY")
	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="COUNTRY")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="LEVEL")
	public String getLevel() {
		return level;
	}

	
	public void setLevel(String level) {
		this.level = level;
	}

	@Column(name="ABOUT_ME")
	public String getAboutMe() {
		return aboutMe;
	}


	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	
	/* Friends section */
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="USER_FRIEND", joinColumns=@JoinColumn(name="USER_ID", nullable = false, updatable = false),
	inverseJoinColumns=@JoinColumn(name="FRIEND_ID", nullable = false, updatable = false))
	public Set<User> getMyFriends() {
		return myFriends;
	}

	public void setMyFriends(Set<User> myFriends) {
		this.myFriends = myFriends;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "myFriends")
	public Set<User> getFriendOf() {
		return friendOf;
	}

	public void setFriendOf(Set<User> friendOf) {
		this.friendOf = friendOf;
	}
	
	
	/* Friend Requests */
	
	@OneToMany(mappedBy="user", targetEntity=FriendRequest.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public List<FriendRequest> getFriendRequests() {
		return friendRequests;
	}

	public void setFriendRequests(List<FriendRequest> myFriendRequests) {
		this.friendRequests = myFriendRequests;
	}
	
}
