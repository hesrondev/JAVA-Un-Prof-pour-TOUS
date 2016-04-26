package com.ingesup.labojava.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.FriendRequest;
import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.Publication;
import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.AnnonceFormBean;
import com.ingesup.labojava.form.Filter;
import com.ingesup.labojava.form.FilterCategory;

@Repository
public class UserDAOImpl implements UserDAO {

	// EntityManager

	@PersistenceContext
	EntityManager entityManager;

	/*
	 * ADD a user
	 */
	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	/*
	 * UPDATE a user
	 */

	@Override
	public User updateUser(User user) {
		return entityManager.merge(user);
	}

	/*
	 * GET all users
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {

		Query query = entityManager
				.createQuery("select u from User u left join fetch u.myFriends " + "left join fetch u.friendOf "
						+ "left join fetch u.annonces " + "left join fetch u.friendRequests");
		List<User> users = query.getResultList();

		return users;
	}

	/*
	 * Params: email, pass Return an user
	 */

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String email, String pass) {

		Query query = entityManager.createQuery("from User u left join fetch u.myFriends " + "left join fetch u.friendOf "
						+ "left join fetch u.annonces " + "left join fetch u.friendRequests " + "left join fetch u.publications "
						+ "where u.email = :email AND u.password = :password");
		
		query.setParameter("email", email);
		query.setParameter("password", pass);

		List<User> users = query.getResultList();

		if (users.isEmpty())
			return null;

		return users.get(0);
	}
	
	
	// FIND BY MAIL
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String email) {

		Query query = entityManager.createQuery("from User u left join fetch u.myFriends " + "left join fetch u.friendOf "
						+ "left join fetch u.annonces " + "left join fetch u.friendRequests " 
						+ "where u.email = :email");
		
		query.setParameter("email", email);

		List<User> users = query.getResultList();

		if (users.isEmpty())
			return null;

		return users.get(0);
	}
	

	/*
	 * Get an user by id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User getUser(Long userID) {

		Query query = entityManager.createQuery(
				"from User u  left join fetch u.myFriends " + "left join fetch u.myFriends " + "left join fetch u.friendOf "
						+ "left join fetch u.annonces " + "left join fetch u.friendRequests " + "left join fetch u.publications "
						+ "where u.id = :id");
		query.setParameter("id", userID);

		List<User> users = query.getResultList();

		if (users.isEmpty())
			return null;

		return users.get(0);
	}

	/*
	 * Also deleted from Student & Professor classes
	 */

	@Override
	public void removeUser(Long userID) {

		Query query = entityManager.createQuery("delete from User u where u.id = :id");
		query.setParameter("id", userID);

		query.executeUpdate();

	}

	/*
	 * Getting the students and professors List
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		Query query = entityManager.createQuery("select s from Student s");
		List<Student> students = query.getResultList();

		return students;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> getAllProfessors() {
		Query query = entityManager.createQuery("select p from Professor p");
		List<Professor> professors = query.getResultList();

		return professors;
	}

	/**
	 * Renvoie les utilisateurs qui dont les noms correspondent au tableau de
	 * valeur entr�e Si le statut est Professor alors on ne cherche que les
	 * profs Si le status est Student alors on ne cherche que les �tudiants
	 * Si le status est User alors on cherche tous les utilisateurs
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getMatchingUsers(String[] splited, String status) {

		List<User> users = new ArrayList<User>();

		if ("Professor".equals(status) || "Student".equals(status) || "User".equals(status)) {

			// On parcours le tableau et on fait la recherche pour mot

			for (String name : splited) {
				Query query = entityManager
						.createQuery("from "+status+" s where s.firstName like :name " + "OR s.lastName like :name");

				query.setParameter("name", "%" + name + "%");

				users.addAll(new ArrayList<User>(query.getResultList()));
			}

			return users;
		}
		
		else {
			System.err.println("Searching Matching Users: INVALID STATUS");
			return null;
		}

	}

	/**
	 * UPDATE Annonce
	 */

	@Override
	public Annonce updateAnnonce(Annonce annonce) {
		return entityManager.merge(annonce);
	}

	/*
	 * 
	 * Get Ad by ID
	 */

	@SuppressWarnings("unchecked")
	@Override
	public Annonce getAdById(Long ID) {
		Query query = entityManager.createQuery("from Annonce a " + "left join fetch a.applications " + "where a.id = :ID");
		query.setParameter("ID", ID);

		List<Annonce> annonces = query.getResultList();

		if (!annonces.isEmpty())
			return annonces.get(0);

		else
			return null;
	}
	
	/*
	 * 
	 * Get Publication by ID
	 */

	@SuppressWarnings("unchecked")
	@Override
	public Publication getPubliById(Long ID) {
		Query query = entityManager.createQuery("from Publication p " + "where p.id = :ID");
		query.setParameter("ID", ID);

		List<Publication> publications = query.getResultList();

		if (!publications.isEmpty())
			return publications.get(0);

		else
			return null;
	}

	/*
	 * Get all ads
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Annonce> getAllAds() {

		Query query = entityManager.createQuery("select a from Annonce a");
		List<Annonce> annonces = query.getResultList();

		return annonces;
	}

	/*
	 * Get All ads by User
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Annonce> getAllAdsByUser(Long userID) {

		Query query = entityManager.createQuery("from Annonce a where a.USER_ID = :id");
		query.setParameter("id", userID);

		List<Annonce> adList = query.getResultList();

		return adList;

	}
	
	/*
	 * Get All publications by User
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Publication> getAllPubliByUser(Long userID) {

		Query query = entityManager.createQuery("from Publication p where p.USER_ID = :id");
		query.setParameter("id", userID);

		List<Publication> publiList = query.getResultList();

		return publiList;

	}

	// Filtered ads

	@SuppressWarnings("unchecked")
	@Override
	public List<Annonce> getFilteredAds(AnnonceFormBean afb) {

		String queryString = initializeStringQuery(afb.getFilters());
		Query query = entityManager.createQuery(queryString);
		List<Annonce> annonces = query.getResultList();

		return annonces;
	}

	// Ajout des filtres � la requ�te

	private String initializeStringQuery(List<Filter> filters) {

		String stringQuery = "from Annonce as a where ";

		for (int i = 0; i < filters.size(); i++) {
			Filter f = filters.get(i);

			if (i > 0)
				stringQuery += " AND ";

			// status
			if (f.geteCategory().equals(FilterCategory.STATUS))
				stringQuery += "a.user.type = '" + f.getValue() + "'";

			// subject
			else if (f.geteCategory().equals(FilterCategory.SUBJECT))
				stringQuery += "a.subject = '" + f.getValue() + "'";

			// level
			else if (f.geteCategory().equals(FilterCategory.LEVEL))
				stringQuery += "a.level = '" + f.getValue() + "'";

			// location
			else if (f.geteCategory().equals(FilterCategory.LOCATION))
				stringQuery += "a.location = '" + f.getValue() + "'";
		}

		return stringQuery;
	}

	// Matching ads -- Recherche d'annonce
	// On recherche d'abord les annonces avec le m�me titre et la m�me ville
	// Puis on recherche celles contenant le titre dans soit le titre, soit la
	// description

	@SuppressWarnings("unchecked")
	public List<Annonce> getMatchingAds(String subject, String location) {

		Query query = null;

		// Cas 0: si tous les champs sont vides

		if (subject.isEmpty() && location.isEmpty())
			return getAllAds();

		// Cas 1: si le titre (seul) est vide

		else if (subject.isEmpty() && !location.isEmpty()) {
			query = entityManager.createQuery("from Annonce a where a.location = :location");
			query.setParameter("location", location);

			return query.getResultList();
		}

		// Cas 2: si le lieu (seul) est vide

		else if (!subject.isEmpty() && location.isEmpty()) {

			query = entityManager.createQuery("from Annonce a where a.subject = :subject OR "
					+ "a.title like :title OR a.description like :description");

			query.setParameter("subject", subject);
			query.setParameter("title", "%" + subject + "%");
			query.setParameter("description", "%" + subject + "%");

			return query.getResultList();
		}

		// Cas 3: si les deux ne sont pas vides

		else {

			query = entityManager.createQuery("from Annonce a where a.subject = :subject OR "
					+ "a.title like :title OR a.description like :description AND a.location like :location");

			query.setParameter("subject", subject);
			query.setParameter("title", "%" + subject + "%");
			query.setParameter("description", "%" + subject + "%");
			query.setParameter("location", "%" + location + "%");

			return query.getResultList();
		}

	}

	/**
	 * GESTION DES DEMANDES D'AMIS
	 */

	@SuppressWarnings("unchecked")
	@Override
	public FriendRequest getFriendRequest(Long reqID) {

		Query query = entityManager.createQuery("from FriendRequest f where f.id = :id");
		query.setParameter("id", reqID);

		List<FriendRequest> fRequests = query.getResultList();

		if (fRequests.isEmpty())
			return null;

		return fRequests.get(0);
	}

	@Override
	public void removeFriendRequest(FriendRequest fRequest) {

		Query query = entityManager
				.createQuery("delete FriendRequest f where " + "f.senderID = :senderID AND f.receiverID = :receiverID");
		query.setParameter("senderID", fRequest.getSenderID());
		query.setParameter("receiverID", fRequest.getReceiverID());

		query.executeUpdate();
	}

	@Override
	public int countUsers() {
		Query query = entityManager.createQuery("from User user");
		return query.getResultList().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getLatestUsers(int max) {
		Query query = entityManager.createQuery("from User user order by user.inscriptionDate desc");
		query.setMaxResults(max);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Annonce> getLatestAnnonces(int max) {
		Query query = entityManager.createQuery("from Annonce a order by a.date desc");
		query.setMaxResults(max);
		return query.getResultList();
	}

}
