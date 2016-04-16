package com.ingesup.labojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.bean.FriendRequest;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.AnnonceFormBean;
import com.ingesup.labojava.service.UserService;
import com.ingesup.labojava.service.UserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("user")
public class HomeController {
	
	
	/* INJECTION DE DEPENDANCES */
	
	private UserService userService = new UserServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}
	

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String homePage(final Model model) {
		
		model.addAttribute("adBean", new AnnonceFormBean());
		return "home";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String indexPage(final Model model) {
		
		model.addAttribute("adBean", new AnnonceFormBean());
		return "home";
	}
	
	@RequestMapping(value="/guide", method = RequestMethod.GET)
	public String displayGuidePage() {
		return "guide";
	}
	
	
	/**
	 * Affichage de la page de status
	 * */
	
	/*
	@RequestMapping(value="/status-page", method = RequestMethod.GET)
	public String displayStatusPage(@RequestParam("status") String status, final Model model) {
			
		model.addAttribute("status", status);
		
		return "statusPage";
	} */
	
	/**
	 * PAGE DE TEST
	 * */
	
	@RequestMapping(value="/test-page")
	public String displayTestPage(final Model model) {
		
		model.addAttribute("userList", userService.getAllUsers());
		return "test-page";
	}
	
	/**
	 * ENVOYER UNE DEMANDE
	 * */
	
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
			
			model.addAttribute("status", "La ressource demandée est introuvable!");
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
		
		System.out.println("//////// Utilisateurs trouvés!");
		
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
		
		// Mise à jour des utilisateurs : ATTENTION --> Un seul élément doit persister. En parcourant sa liste,
		// Il persistera automatiquement les autres éléments
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
	
	
}
