package com.ingesup.labojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.ingesup.labojava.bean.FriendRequest;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.service.UserService;
import com.ingesup.labojava.service.UserServiceImpl;

@Controller
@SessionAttributes("currentUser")
public class ProfileController {

	
	/* INJECTION DE DEPENDANCES */
	
	private UserService userService = new UserServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	/* Profil priv� */
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String profilePage(WebRequest request, final Model model) {
		
		User currentUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);
		
		if (currentUser != null)
			return "private/profile-private";
		
		else
			return "redirect:/login";
	}
	
	/* Profil Public */
	
	@RequestMapping(value="profile/{userID}")
	public String publicProfilePage(@PathVariable("userID") Long userID, final Model model) {
		
		User user = userService.getUser(userID);
		
		if (user == null) {
			model.addAttribute("statusMessage", "Profile utilisateur introuvable!");
			return "status-page";
		}
		
		// Si trouv�
		
		model.addAttribute("user", user);
		
		return "profile-public";
	}
	

	/**
	 * ENVOYER UNE DEMANDE * */
	
	@RequestMapping(value="/inviter/{senderID}_{receiverID}", method = RequestMethod.GET)
	public String sendFriendRequest(@PathVariable("senderID") Long senderID, 
			@PathVariable("receiverID") Long receiverID, final Model model) {
		
		System.out.println("///////// ENVOIE DE L'INVITATION EN COURS...");
		
		/* Recherche des utilisateurs */
		
		User senderUser = userService.getUser(senderID);
		User receiverUser = userService.getUser(receiverID);
		
		if (senderUser == null || receiverUser == null) {
			model.addAttribute("status", "La ressource 'Utilisateur' est introuvable");
			return "redirect:/statusPage";
		}
		
		System.out.println("////// USERS FOUNDS!!!");
		System.out.println("//// FriendRequestsIN (size)" +receiverUser.getFriendRequests().size());
		System.out.println("//// FriendRequestsOUT (size)" +senderUser.getFriendRequests().size());
		
		/* Friend request */
		
		FriendRequest receivedRequest = new FriendRequest(senderUser, receiverUser, true);
		FriendRequest sentRequest = new FriendRequest(senderUser, receiverUser, false);
		
		receiverUser.addFriendRequest(receivedRequest);
		senderUser.addFriendRequest(sentRequest);
		
		System.out.println("//// FriendRequestsIN (size)" +receiverUser.getFriendRequests().size());
		System.out.println("//// FriendRequestsOUT (size)" +senderUser.getFriendRequests().size());
		
		userService.updateUser(receiverUser);
		userService.updateUser(senderUser);
		
		System.out.println("/////// UPDATED MyFRIENDREQUESTS_IN : " +receiverUser.getFriendRequests().size());
		
		return "redirect:/test-page";
	}
	
	
	
	
	/**
	 * GESTION D'UNE DEMANDE ACCEPT - REFUSE
	 * */
	
	@RequestMapping(value="/friend-request:{response}/{reqID}", method = RequestMethod.GET)
	public String processFriendRequest(@PathVariable("response") String response, @PathVariable("reqID") Long reqID, 
			final Model model) {
		
		System.out.println("//////// FRIEND REQUEST PROCESSING...");
		
		
		/* Get the concerning Request */
		
		FriendRequest fRequest = userService.getFriendRequest(reqID);
		
		if (fRequest == null) {
			
			model.addAttribute("status", "La ressource demand�e est introuvable!");
			return "statusPage";
		}
		
		/* On ajoute l'ami dans sa liste d'amis (deux sens)
		 * On supprime la demande des listes (deux sens)
		 * 
		*/ 
		
		User sender = userService.getUser(fRequest.getSenderID());
		User receiver =  userService.getUser(fRequest.getReceiverID());
		
		if (sender == null || receiver == null) {
			model.addAttribute("status", "La ressource 'Utilisateur' est introuvable");
			return "redirect:/statusPage";
		}
		
		System.out.println("//////// Utilisateurs trouv�s!");
		
		System.out.println("///////// FRIENDLIST (sender)" +sender.getMyFriends().size());
		System.out.println("///////// FRIENDLIST (receiver)" +receiver.getMyFriends().size());
		
		receiver.removeSentFriendRequest(fRequest);
		sender.removeFriendRequest(fRequest);
		
		
		if ("accept".equals(response)) {
			sender.addFriend(receiver);
			receiver.addFriend(sender);
		}
		
		System.out.println("///////// FRIENDLIST_ADD (sender)" +sender.getMyFriends().size());
		System.out.println("///////// FRIENDLIST_ADD (receiver)" +receiver.getMyFriends().size());
		
		// Mise � jour des utilisateurs : ATTENTION --> Un seul �l�ment doit persister. En parcourant sa liste,
		// Il persistera automatiquement les autres �l�ments
		//userService.updateUser(sender);
		userService.updateUser(receiver);
		
		/** SUPPRIMER LES TABLES DE DEMANDES *
		 * 
		 * 
		 * */
		
		userService.removeFriendRequest(fRequest);
		
		sender = userService.getUser(fRequest.getReceiverID());
		
		System.out.println("///////// UP! FRIENDLIST (sender)" +sender.getMyFriends().size());
		System.out.println("///////// UP! FRIENDLIST_OF (sender)" +sender.getFriendOf().size());
		
		
		return "redirect:/test-page";
	}
	
	/** SUPPRIMER UN AMI */
	
	@RequestMapping(value="/removeContact/{userID}:{cID}", method = RequestMethod.GET)
	public String removeContact(@PathVariable("userID") Long userID, @PathVariable("cID") Long cID, final Model model) {
		
		String URL = "test-page";
		
		System.out.println("Suppression d'un contact...");
		
		User contact = userService.getUser(cID);
		User currentUser = userService.getUser(userID);
		
		/** VERIFIER QUE LA SESSION EST ACTIVE  */
		
		if (currentUser == null || contact == null) {
			model.addAttribute("status", "Utilisateur introuvable!");
			return "redirect:/statusPage";
		}
		
		/* Utilisateurs trouv�s */
		
		currentUser.removeFriend(contact.getId());
		contact.removeFriend(currentUser.getId());
		
		// Mettre � jour les deux car il n'y a plus de mise � jour r�currente
		userService.updateUser(currentUser);
		userService.updateUser(contact);
		
		System.out.println("Contact supprim� avec succ�s!"); 
		
		return "redirect:/"+URL;
	}

}
