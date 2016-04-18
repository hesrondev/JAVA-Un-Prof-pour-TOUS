package com.ingesup.labojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.ingesup.labojava.bean.FriendRequest;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.FriendRequestBean;
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
	
	

	/* Profil privé */
	
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
		
		// Si trouvé
		
		model.addAttribute("user", user);
		
		return "profile-public";
	}
	

	/**
	 * ENVOYER UNE DEMANDE * */
	
	@RequestMapping(value="/profile/request-processing/add", method = RequestMethod.POST)
	public String sendFriendRequest(WebRequest request, @ModelAttribute("requestBean") FriendRequestBean requestBean,
			final Model model) {
		
		System.out.println("///////// ENVOIE DE L'INVITATION EN COURS...");
		
		/* Recherche des utilisateurs */
		
		User senderUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);
		
		if (senderUser == null) {
			model.addAttribute("statusMessage", "ajouter un contact");
			return "redirect:/restriction";
		}
		
		/** IL FAUT VERIFIER LA VALIDITE DE LA REQUETE !!!*/
		
		User receiverUser = userService.getUser(requestBean.getReceiverID());
		
		if (receiverUser == null) {
			model.addAttribute("status", "La ressource 'Utilisateur' est introuvable");
			return "redirect:/status-page";
		}
		
		/* Friend request */
		boolean requestIsSent = true;
		
		// Si on est pas déjà amis
		// Si la requête n'existe pas déjà
		// Si la requête n'est pas déjà reçue
		
		if (senderUser.getFriend(requestBean.getReceiverID()) == null && 
				senderUser.hasRequestedFriend(requestBean.getReceiverID())  == -1 &&
				senderUser.hasBeenRequestedByFriend(requestBean.getReceiverID()) == -1) {
			
			FriendRequest receivedRequest = new FriendRequest(senderUser, receiverUser, requestIsSent);
			FriendRequest sentRequest = new FriendRequest(senderUser, receiverUser, !requestIsSent);
			
			receiverUser.addFriendRequest(receivedRequest);
			senderUser.addFriendRequest(sentRequest);
			
			userService.updateUser(receiverUser);
			userService.updateUser(senderUser);
			
			model.addAttribute("currentUser", userService.getUser(senderUser.getId()));
		}
		else
			System.out.println("DEMANDE DEJA EN ATTENTE DE TRAITEMENT!");
		
		
		return "redirect:/test-page";
	}
	
	

	
	/**
	 * GESTION D'UNE DEMANDE : ACCEPT - REFUSE - CANCEL
	 */
	
	@RequestMapping(value="/profile/request-processing/{response}", method = RequestMethod.POST)
	public String processFriendRequest(WebRequest request, @ModelAttribute("requestBean") FriendRequestBean requestBean,
			@PathVariable("response") String response, final Model model) {
		
		System.out.println("TRAITEMENT DE LA REQUETE D'AMIS EN COURS...");
		
		/* Recherche de l'utilisateur courant */
		
		User currentUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);
		
		if (currentUser == null) {
			model.addAttribute("statusMessage", "traiter une requête");
			return "redirect:/restriction";
		}
		
		/* Get the concerning Request */
				
		FriendRequest fRequest = currentUser.getFriendRequest(requestBean.getId());
		
		if (fRequest == null) {
			
			model.addAttribute("status", "La ressource 'Requête' demandée est introuvable!");
			return "statusPage";
		}

		
		/** CASES */
		
		if ("accept".equals(response) || "refuse".equals(response)) {
		
			System.out.println("ACCEPT OU REFUSE RESQUEST !!!");
			
			// On récupère celui qui l'a envoyé
			User senderUser = userService.getUser(fRequest.getSenderID());
			
			if (senderUser == null) {
				
				model.addAttribute("status", "La ressource 'Utilisateur' demandée est introuvable!");
				return "statusPage";
			}
			
			// Suppression des requêtes de contact
			
			senderUser.removeFriendRequest(fRequest);
			currentUser.removeFriendRequest(fRequest);			
			
			if ("accept".equals(response)) {
				currentUser.addFriend(senderUser);
				senderUser.addFriend(currentUser);
			}
			
			/* Mise à jour des utilisateurs : ATTENTION --> Un seul élément doit persister. En parcourant sa liste,
			Il persistera automatiquement les autres éléments */
			
			userService.updateUser(currentUser);
	
			userService.removeFriendRequest(fRequest);
			
			model.addAttribute("currentUser", userService.getUser(currentUser.getId()));
			
			return "redirect:/test-page";
		}
		
		else if ("cancel".equals(response)) {
		
			System.out.println("CANCEL RESQUEST !!!");
			
			// On récupère celui à qui on l'a envoyé
			User receiverUser = userService.getUser(fRequest.getReceiverID());
			
			if (receiverUser == null) {
				
				model.addAttribute("status", "La ressource 'Utilisateur' demandée est introuvable!");
				return "statusPage";
			}
			
			/* Suppression des requêtes de contact
			 * On supprime d'abord celui du receveur car fRequest est celui de l'utilisateur courant
			 */
			
			receiverUser.removeFriendRequest(fRequest); 
			currentUser.removeFriendRequest(fRequest);
			
			/* Mise à jour des deux utilisateurs : PAS DE RECURSIVITE */
			
			userService.updateUser(currentUser);
			userService.updateUser(receiverUser);
			
			userService.removeFriendRequest(fRequest);
			
			model.addAttribute("currentUser", userService.getUser(currentUser.getId()));
			
			return "redirect:/test-page";
		}
		
		else {
			model.addAttribute("statusMessage", "Page Introuvable!");
			return "redirect:/status-page";
		}
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
		
		/* Utilisateurs trouvés */
		
		currentUser.removeFriend(contact.getId());
		contact.removeFriend(currentUser.getId());
		
		// Mettre à jour les deux car il n'y a plus de mise à jour récurrente
		userService.updateUser(currentUser);
		userService.updateUser(contact);
		
		System.out.println("Contact supprimé avec succès!"); 
		
		return "redirect:/"+URL;
	}

}
