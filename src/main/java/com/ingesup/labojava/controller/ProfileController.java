package com.ingesup.labojava.controller;

import javax.validation.Valid;

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
import com.ingesup.labojava.form.FormMaps;
import com.ingesup.labojava.form.FriendRequestBean;
import com.ingesup.labojava.form.InscriptionFormBean;
import com.ingesup.labojava.form.PublicationFormBean;
import com.ingesup.labojava.form.UserComplementInfosBean;
import com.ingesup.labojava.form.UserFormBean;
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

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profilePage(WebRequest request, final Model model) {

		User currentUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);

		if (currentUser != null) {
			model.addAttribute("currentUser", userService.getUser(currentUser.getId()));
			return "private/profile-private";
		}

		return "redirect:/login";
	}

	/* INJECTION DES BEANS */

	@ModelAttribute("userBean")
	public UserFormBean addUserBean() {
		return new UserFormBean();
	}

	@ModelAttribute("requestBean")
	public FriendRequestBean addFriendRequest() {
		return new FriendRequestBean();
	}

	@ModelAttribute("publiBean")
	public PublicationFormBean addPubliBean() {
		return new PublicationFormBean();
	}

	// Méthode qui injecte les MAPs
	// Ajouter cette méthode dans chaque controlleur qui affiche une JSP qui
	// doit utiliser cet objet
	// J'ai choisi de séparer les MAPs pour les utiliser dans plusieur
	// formulaires de manière indépendante
	// RDV DANS LA JSP Du formulaire de completement d'infos pour voir ma
	// déclaration

	@ModelAttribute("formMaps")
	public FormMaps addMaps() {
		return new FormMaps();
	}

	/* Profil Public */

	@RequestMapping(value = "profile/*.*/{userID}")
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
	 * ENVOYER UNE DEMANDE *
	 */

	@RequestMapping(value = "/profile/request-processing/add", method = RequestMethod.POST)
	public String sendFriendRequest(WebRequest request, @ModelAttribute("requestBean") FriendRequestBean requestBean,
			final Model model) {

		System.out.println("///////// ENVOIE DE L'INVITATION EN COURS...");

		/* Recherche des utilisateurs */

		User senderUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);

		if (senderUser == null) {
			model.addAttribute("statusMessage", "ajouter un contact");
			return "redirect:/restriction";
		}

		/** IL FAUT VERIFIER LA VALIDITE DE LA REQUETE !!! */

		User receiverUser = userService.getUser(requestBean.getReceiverID());

		if (receiverUser == null) {
			model.addAttribute("status", "La ressource 'Utilisateur' est introuvable");
			return "redirect:/status-page";
		}

		/* Friend request */
		boolean requestIsSent = true;

		// Si on est pas d�j� amis
		// Si la requ�te n'existe pas d�j�
		// Si la requ�te n'est pas d�j� re�ue

		if (senderUser.getFriend(requestBean.getReceiverID()) == null
				&& senderUser.hasRequestedFriend(requestBean.getReceiverID()) == -1
				&& senderUser.hasBeenRequestedByFriend(requestBean.getReceiverID()) == -1) {

			FriendRequest receivedRequest = new FriendRequest(senderUser, receiverUser, requestIsSent);
			FriendRequest sentRequest = new FriendRequest(senderUser, receiverUser, !requestIsSent);

			receiverUser.addFriendRequest(receivedRequest);
			senderUser.addFriendRequest(sentRequest);

			userService.updateUser(receiverUser);
			userService.updateUser(senderUser);

			model.addAttribute("currentUser", userService.getUser(senderUser.getId()));
		} else
			System.out.println("DEMANDE DEJA EN ATTENTE DE TRAITEMENT!");

		return "redirect:/profile";
	}

	/**
	 * GESTION D'UNE DEMANDE : ACCEPT - REFUSE - CANCEL
	 */

	@RequestMapping(value = "/profile/request-processing/{response}", method = RequestMethod.POST)
	public String processFriendRequest(WebRequest request, @ModelAttribute("requestBean") FriendRequestBean requestBean,
			@PathVariable("response") String response, final Model model) {

		System.out.println("TRAITEMENT DE LA REQUETE D'AMIS EN COURS...");

		/* Recherche de l'utilisateur courant */

		User currentUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);

		if (currentUser == null) {
			model.addAttribute("statusMessage", "traiter une requ�te");
			return "redirect:/restriction";
		}

		/* Get the concerning Request */

		FriendRequest fRequest = currentUser.getFriendRequest(requestBean.getId());

		if (fRequest == null) {

			model.addAttribute("status", "La ressource 'Requ�te' demand�e est introuvable!");
			return "statusPage";
		}

		/** CASES */

		if ("accept".equals(response) || "refuse".equals(response)) {

			System.out.println("ACCEPT OU REFUSE RESQUEST !!!");

			// On r�cup�re celui qui l'a envoy�
			User senderUser = userService.getUser(fRequest.getSenderID());

			if (senderUser == null) {

				model.addAttribute("status", "La ressource 'Utilisateur' demand�e est introuvable!");
				return "statusPage";
			}

			// Suppression des requ�tes de contact

			senderUser.removeFriendRequest(fRequest);
			currentUser.removeFriendRequest(fRequest);

			if ("accept".equals(response)) {
				currentUser.addFriend(senderUser);
				senderUser.addFriend(currentUser);
			}

			/*
			 * Mise � jour des utilisateurs : ATTENTION --> Un seul �l�ment doit
			 * persister. En parcourant sa liste, Il persistera automatiquement
			 * les autres �l�ments
			 */

			userService.updateUser(currentUser);

			userService.removeFriendRequest(fRequest);

			model.addAttribute("currentUser", userService.getUser(currentUser.getId()));

			return "redirect:/profile";
		}

		else if ("cancel".equals(response)) {

			System.out.println("CANCEL RESQUEST !!!");

			// On r�cup�re celui � qui on l'a envoy�
			User receiverUser = userService.getUser(fRequest.getReceiverID());

			if (receiverUser == null) {

				model.addAttribute("status", "La ressource 'Utilisateur' demand�e est introuvable!");
				return "statusPage";
			}

			/*
			 * Suppression des requ�tes de contact On supprime d'abord celui du
			 * receveur car fRequest est celui de l'utilisateur courant
			 */

			receiverUser.removeFriendRequest(fRequest);
			currentUser.removeFriendRequest(fRequest);

			/* Mise � jour des deux utilisateurs : PAS DE RECURSIVITE */

			userService.updateUser(currentUser);
			userService.updateUser(receiverUser);

			userService.removeFriendRequest(fRequest);

			model.addAttribute("currentUser", userService.getUser(currentUser.getId()));

			return "redirect:/profile";
		}

		else {
			model.addAttribute("statusMessage", "Page Introuvable!");
			return "redirect:/status-page";
		}
	}

	/** SUPPRIMER UN AMI */

	@RequestMapping(value = "/profile/request-processing/delete", method = RequestMethod.POST)
	public String removeContact(WebRequest request, @ModelAttribute("requestBean") FriendRequestBean requestBean,
			final Model model) {

		System.out.println("Suppression d'un contact...");

		/* Recherche de l'utilisateur courant */

		User currentUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);

		if (currentUser == null) {
			model.addAttribute("statusMessage", "traiter une requ�te");
			return "redirect:/restriction";
		}

		User contact = userService.getUser(requestBean.getReceiverID());

		/** VERIFIER QUE LA SESSION EST ACTIVE */

		if (contact == null) {
			model.addAttribute("status", "Utilisateur introuvable!");
			return "redirect:/statusPage";
		}

		/* Utilisateurs trouv�s */

		currentUser.removeFriend(contact.getId());
		contact.removeFriend(currentUser.getId());

		// Mettre � jour les deux car il n'y a plus de mise � jour r�currente
		userService.updateUser(currentUser);
		userService.updateUser(contact);

		model.addAttribute("currentUser", userService.getUser(currentUser.getId()));

		System.out.println("Contact supprimé� avec succès!");

		return "redirect:/profile";
	}

	/** FORMULAIRE DE COMPLEMENT D'INFOS APRES INSCRIPTION */

	// Affichage

	@RequestMapping(value = "/profile/completeUserInfos", method = RequestMethod.GET)
	public String displayUserComplementInfosForm(WebRequest request, Model model) {

		model.addAttribute("userInfosBean", new UserComplementInfosBean());

		/* V�rification de la session */

		User user = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);

		if (user == null) {
			System.err.println("COMPLETE INFOS: Session not found!");
			return "redirect:/inscription";
		}

		return "private/userComplementInfosPage";
	}

	@RequestMapping(value = "/profile/completeUserInfos", method = RequestMethod.POST)
	public String saveCompleteUserInfos(WebRequest request,
			@ModelAttribute("userInfosBean") UserComplementInfosBean ucb, BindingResult bindingResult, Model model) {

		/* V�rification de la session */

		User currentUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);

		if (currentUser == null) {
			System.err.println("COMPLETE INFOS: Session not found!");
			model.addAttribute("statusMessage", "compl�ter les informations de votre profil");
			return "redirect:/restriction";
		}
		/*
		 * 
		 * if (bindingResult.hasErrors()) {
		 * 
		 * System.err.println(bindingResult.getFieldErrorCount());
		 * model.addAttribute("errorStatus", "V�rifiez votre saisie.");
		 * model.addAttribute("userInfosBean", new UserComplementInfosBean());
		 * return "/private/userComplementInfosPage"; }
		 */

		currentUser = ucb.completeInfos(currentUser);

		userService.updateUser(currentUser);

		model.addAttribute("currentUser", userService.getUser(currentUser.getId()));

		return "redirect:/profile";
	}

}
