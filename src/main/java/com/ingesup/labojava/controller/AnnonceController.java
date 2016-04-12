package com.ingesup.labojava.controller;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.factory.AnnonceFactory;
import com.ingesup.labojava.form.AnnonceFormBean;
import com.ingesup.labojava.service.UserService;
import com.ingesup.labojava.service.UserServiceImpl;

@Controller
@RequestMapping("/annonces")
@SessionAttributes("user")
public class AnnonceController {
	
	// List d'annonces
	
	AnnonceFormBean annoncefb = new AnnonceFormBean();
	List<Annonce> annonces = new ArrayList<Annonce>();

	// Injection des services

	private UserService userService = new UserServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	// Affichage de la page de création d'une annonce
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String displayAdCreationPage(final Model model) {
		
		model.addAttribute("adBean", new AnnonceFormBean());
		return "createAd";
	}
	
	
	// Méthode POST d'une annonce
	
	@RequestMapping(value="create/{studentID}")
	public ModelAndView createAdPost(@ModelAttribute("adBean") @Valid final AnnonceFormBean adFormBean, 
			@PathVariable(value="studentID") Long studentID, final BindingResult bindingResult) {
		
		ModelAndView mView = new ModelAndView();
		
		// Vérification de l'utilisateur
		
		if (studentID == 0) {
			
			String formStatus = "Vous n'êtes pas connecté! Connectez-vous pour publier une annonce.";
			
			mView.addObject("formStatus", formStatus);
			mView.setViewName("createAd");
			return mView;
		}
		
		
		// S'il y'a des erreurs
		
		if (bindingResult.hasErrors()) {
			
			String formStatus = "Adresse mail ou mot de passe invalides!";
			
			mView.addObject("formStatus", formStatus);
			mView.setViewName("createAd");
			return mView;
		}
		
		// Création de l'annonce
		
		AnnonceFactory annonceFactory = new AnnonceFactory();
		Annonce ad = annonceFactory.createAnnonce(adFormBean);
		
		// On cherche l'utilisateur, on ajoute son annonce, on le met à jour
		
		User user = userService.getUser(studentID);
		
		if (user != null) {
			
			user.addAnnonce(ad);
			userService.updateUser(user);
			
			mView.addObject("user", user);
			mView.setViewName("redirect:/profile");
			
			return mView;
		}
		
		String formStatus = "Utilisateur non trouvé!";
		mView.addObject("formStatus", formStatus);
		mView.setViewName("createAd");
		return mView;
	}
	
	
	// Affichage de la page des annonces
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String displayAdsPage(final Model model) {
		
		model.addAttribute("adBean", new AnnonceFormBean());
		
		// Envoie des requêtes
		annonces = userService.getAllAds();
		
		model.addAttribute("listAnnonces", annonces);
		return "annonces";
	}
	
	
	/* Ajouter un filtre
	 * Lorqu'on clique sur un filtre, on l'ajoute à la liste de filtres et on réinitialise les résultats
	 * Si on clique encore sur le même filtre on l'enlève
	 */
	
	@RequestMapping(value="/{category}={value}", method = RequestMethod.GET)
	private ModelAndView addStatusFilter(@PathVariable(value="category") final String category,
			@PathVariable(value="value") final String value) {
		
		ModelAndView mView = new ModelAndView();
		
		// recharger le bean sur la jsp
		mView.addObject("adBean", new AnnonceFormBean());
		
		annoncefb.updateFilter(category, value);
		
		
		// refresh results
		
		annonces = userService.getFilteredAds(annoncefb);
		mView.addObject("listAnnonces", annonces);
		
		mView.setViewName("redirect:/annonces");
		
		return mView;
	}
	

	
	

}
