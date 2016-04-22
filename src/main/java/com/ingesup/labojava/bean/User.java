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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USER")
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
	protected String gradeLevel;
	protected String aboutMe;
	private String profession;

	// Collections

	protected Set<Annonce> annonces = new HashSet<Annonce>();
	protected Set<User> myFriends = new HashSet<User>();
	protected Set<User> friendOf = new HashSet<User>();

	/* Listes des demandes: re�ues et envoy�es */
	protected Set<FriendRequest> friendRequests = new HashSet<FriendRequest>();

	public User() {
		inscriptionDate = new Date();
		id = 0L;
	}

	// toString
	public String toString() {

		return "ID : " + id + "\nFIRSTNAME : " + firstName + "\nLASTNAME : " + lastName + "\nEMAIL : " + email
				+ "\nPASSWORD : " + password;
	}

	/**
	 * Ajout et suppression des �éléments dans les listes
	 */
	
	
	// Ignorer cette méthode
	@Transient
	public boolean isStudent() {
		if ("STUDENT".equals(type))
			return true;
		else
			return false;
	}
	
	public String toStringJoinedDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		return dateFormat.format(inscriptionDate);
	}

	public String toStringBirthDate() {

		if (birthDate != null) {
			DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
			return dateFormat.format(birthDate);
		}

		return null;
	}

	public int friendsCount() {
		return myFriends.size();
	}

	public int publicationsCount() {
		return annonces.size();
	}

	// Demandes d'amis reçues
	public int receivedFriendRequestsCount() {
		int counter = 0;

		for (Iterator<FriendRequest> iterator = friendRequests.iterator(); iterator.hasNext();) {
			FriendRequest fr = iterator.next();

			if (fr.isReceived()) {

				counter++;
			}
		}

		return counter;
	}

	// Demandes d'amis reçues
	public int sentFriendRequestsCount() {
		int counter = 0;

		for (Iterator<FriendRequest> iterator = friendRequests.iterator(); iterator.hasNext();) {
			FriendRequest fr = iterator.next();

			if (fr.isSent()) {

				counter++;
			}
		}

		return counter;
	}

	// Toutes les candidatures d'une annonce
	public int annonceApplicationsCount(int adID) {
		int counter = 0;

		for (Iterator<Annonce> iterator = annonces.iterator(); iterator.hasNext();) {
			Annonce annonce = iterator.next();

			if (annonce.getId() == adID)
				counter = annonce.applicationsCount();
		}

		return counter;
	}

	// Toutes les candidatures de toutes les annonces
	public int allAnnonceApplicationsCount() {
		int counter = 0;

		for (Iterator<Annonce> iterator = annonces.iterator(); iterator.hasNext();) {
			Annonce annonce = iterator.next();

			counter += annonce.applicationsCount();
		}

		return counter;
	}

	// Toutes les notifications cumulées

	public int notificationsCount() {
		return receivedFriendRequestsCount() + allAnnonceApplicationsCount();
	}

	public void addAnnonce(Annonce ad) {
		annonces.add(ad);
	}

	public void removeAnnonce(Annonce ad) {

		for (Iterator<Annonce> iterator = annonces.iterator(); iterator.hasNext();) {
			Annonce annonce = iterator.next();
			if (annonce.getId() == ad.getId())
				iterator.remove();
		}
	}

	// Add friend request

	public void addFriendRequest(FriendRequest fRequest) {
		friendRequests.add(fRequest);
	}

	/*
	 * Supprime un une requ�te Renvoie vrai si "trouv� et supprim� Renvoie faux
	 * si non trouv�
	 */
	public boolean removeFriendRequest(FriendRequest req) {

		for (Iterator<FriendRequest> iterator = friendRequests.iterator(); iterator.hasNext();) {
			FriendRequest fr = iterator.next();

			if (fr.getReceiverID() == req.getReceiverID() && fr.getSenderID() == req.getSenderID()) {
				System.out.println("Suppression de la requete " + fr.getId() + " par " + firstName);
				iterator.remove();
				return true;
			}
		}

		return false;
	}

	// R�cup�rer une requ�te

	public FriendRequest getFriendRequest(Long id) {

		for (Iterator<FriendRequest> iterator = friendRequests.iterator(); iterator.hasNext();) {
			FriendRequest fr = iterator.next();
			if (fr.getId() == id)
				return fr;
		}

		return null;
	}

	// V�rifie si le requ�te existe d�j�

	// V�rifie si je n'ai pas d�j� invit� un ami / si on ne m'a pas d�j� invit�
	// Renvoie l'ID de la requ�te

	public Long hasRequestedFriend(Long friendID) {

		for (Iterator<FriendRequest> iterator = friendRequests.iterator(); iterator.hasNext();) {
			FriendRequest fr = iterator.next();
			if (fr.getReceiverID() == friendID)
				return fr.getId();
		}

		return -1L;
	}

	// V�rifie si je n'ai pas d�j� invit� un ami / si on ne m'a pas d�j� invit�
	// Renvoie l'ID de la requ�te

	public Long hasBeenRequestedByFriend(Long friendID) {

		for (Iterator<FriendRequest> iterator = friendRequests.iterator(); iterator.hasNext();) {
			FriendRequest fr = iterator.next();
			if (fr.getSenderID() == friendID)
				return fr.getId();
		}

		return -1L;
	}

	// ADD a friend

	public void addFriend(User user) {
		myFriends.add(user);
	}

	public void addFriendOf(User user) {
		friendOf.add(user);
	}

	// R�cup�re un ami

	public User getFriend(Long id) {

		for (Iterator<User> iterator = myFriends.iterator(); iterator.hasNext();) {
			User s = iterator.next();
			if (s.getId() == id) {
				return s;
			}
		}

		return null;
	}

	/*
	 * Supprime un ami Renvoie vrai si "trouv� et supprim� Renvoie faux si non
	 * trouv�
	 */
	public boolean removeFriend(Long userID) {

		for (Iterator<User> iterator = myFriends.iterator(); iterator.hasNext();) {
			User s = iterator.next();
			if (s.getId() == userID) {
				iterator.remove();
				return true;
			}
		}

		return false;
	}

	/*
	 * Getters and Setters
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LASTNAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/* LIST of annonces */

	@OneToMany(mappedBy = "user", targetEntity = Annonce.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(Set<Annonce> annonces) {
		this.annonces = annonces;
	}

	@Column(name = "USER_TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "INSCRIPTION_DATE")
	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	@Column(name = "BIRTH_DATE")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "PHONE_NUMBER")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "COUNTRY")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "GRADE_LEVEL")
	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String level) {
		this.gradeLevel = level;
	}

	@Column(name = "ABOUT_ME")
	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	/* Friends section */

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_FRIEND", joinColumns = @JoinColumn(name = "USER_ID", nullable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "FRIEND_ID", nullable = false, updatable = false))
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

	@OneToMany(mappedBy = "user", targetEntity = FriendRequest.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<FriendRequest> getFriendRequests() {
		return friendRequests;
	}

	public void setFriendRequests(Set<FriendRequest> myFriendRequests) {
		this.friendRequests = myFriendRequests;
	}

	// Equals AND hASH

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		User other = (User) obj;

		if (id == other.id && email == other.email)
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
