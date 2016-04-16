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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.AnnonceApplication;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.factory.AnnonceApplicationFactory;
import com.ingesup.labojava.factory.AnnonceFactory;
import com.ingesup.labojava.form.AnnonceApplicationFormBean;
import com.ingesup.labojava.form.AnnonceFormBean;
import com.ingesup.labojava.form.Filter;
import com.ingesup.labojava.form.FilterCategory;
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

	// Affichage de la page de cr�ation d'une annonce

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String displayAdCreationPage(final Model model) {

		model.addAttribute("adBean", new AnnonceFormBean());
		return "createAd";
	}

	// M�thode POST d'une annonce

	@RequestMapping(value = "create/{studentID}")
	public ModelAndView createAdPost(@ModelAttribute("adBean") @Valid final AnnonceFormBean adFormBean,
			@PathVariable(value = "studentID") Long studentID, final BindingResult bindingResult) {

		ModelAndView mView = new ModelAndView();

		// V�rification de l'utilisateur

		if (studentID == 0) {

			String formStatus = "Vous n'�tes pas connect�! Connectez-vous pour publier une annonce.";

			mView.addObject("formStatus", formStatus);
			mView.setViewName("createAd");
			return mView;
		}

		// S'il y'a des erreurs

		if (bindingResult.hasErrors()) {

			String formStatus = "Erreur: v�rifiez les champs!";

			mView.addObject("formStatus", formStatus);
			mView.setViewName("createAd");
			return mView;
		}

		// Cr�ation de l'annonce

		AnnonceFactory annonceFactory = new AnnonceFactory();
		Annonce ad = annonceFactory.createAnnonce(adFormBean);

		// On cherche l'utilisateur, on ajoute son annonce, on le met � jour

		User user = userService.getUser(studentID);

		if (user != null) {
			// si l'utilisateur est connect�, on lui ajoute l'annonce
			// Mais on ajoute aussi l'utilisateur dans l'annonce
			user.addAnnonce(ad);
			ad.setUser(user);
			userService.updateUser(user);

			mView.addObject("user", user);
			mView.setViewName("redirect:/profile");

			return mView;
		}

		String formStatus = "Utilisateur non trouv�!";
		mView.addObject("formStatus", formStatus);
		mView.setViewName("createAd");
		return mView;
	}

	/*
	 * Rechercher une annonce
	 * 
	 */

	@RequestMapping(value = "/recherche", method = RequestMethod.GET)
	public String searchAnnonces(@RequestParam("subject") final String subject,
			@RequestParam("location") final String location, final Model model) {

		annonces = userService.getMatchingAds(subject, location);

		/* afficher le bean du formulaire de rechere */

		model.addAttribute("adBean", new AnnonceFormBean());

		/* afficher uniquement les filtres concern�es */

		List<Filter> allFilters = Utilities.createFilters(annonces);
		model.addAttribute("statusFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.STATUS));
		model.addAttribute("locationFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.LOCATION));
		model.addAttribute("subjectFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.SUBJECT));
		model.addAttribute("levelFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.LEVEL));

		model.addAttribute("listAnnonces", annonces);

		// R�afficher les crit�res
		model.addAttribute("subject", subject);
		model.addAttribute("location", location);

		return "annonces";

	}

	// Affichage de la page des annonces

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String displayAdsPage(final Model model) {

		model.addAttribute("adBean", new AnnonceFormBean());

		// Envoie des requ�tes
		annonces = userService.getAllAds();

		/* afficher uniquement les filtres concern�es */

		List<Filter> allFilters = Utilities.createFilters(annonces);
		model.addAttribute("statusFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.STATUS));
		model.addAttribute("locationFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.LOCATION));
		model.addAttribute("subjectFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.SUBJECT));
		model.addAttribute("levelFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.LEVEL));

		model.addAttribute("listAnnonces", annonces);
		return "annonces";
	}

	/*
	 * Ajouter un filtre Lorqu'on clique sur un filtre, on l'ajoute � la liste
	 * de filtres et on r�initialise les r�sultats Si on clique encore sur le
	 * m�me filtre on l'enl�ve
	 */

	@RequestMapping(value = "/{category}={value}", method = RequestMethod.GET)
	private ModelAndView addFilter(@PathVariable(value = "category") final String category,
			@PathVariable(value = "value") final String value) {

		ModelAndView mView = new ModelAndView();

		// recharger le bean sur la jsp
		mView.addObject("adBean", new AnnonceFormBean());

		annoncefb.updateFilter(category, value);

		// refresh results

		annonces = userService.getFilteredAds(annoncefb);
		mView.addObject("listAnnonces", annonces);

		// afficher uniquement les filtres concern�es

		List<Filter> allFilters = Utilities.createFilters(annonces);

		mView.addObject("statusFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.STATUS));
		mView.addObject("locationFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.LOCATION));
		mView.addObject("subjectFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.SUBJECT));
		mView.addObject("levelFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.LEVEL));

		mView.setViewName("annonces");

		return mView;
	}

	// Affichage des d�tails d'une annonce

	@RequestMapping(value = "/{adID}", method = RequestMethod.GET)
	public String displayAnnonceDetails(@PathVariable("adID") final Long ID, final Model model) {

		/* Recherche de l'annonce */

		Annonce annonce = userService.getAdById(ID);

		if (annonce == null) {
			model.addAttribute("status", "Annonce introuvable!");
			return "statusPage";
		}

		/* R�cup�ration de la liste des annonces similaires */

		annonces = userService.getMatchingAds(annonce.getSubject(), annonce.getLocation());

		System.out.println("SIMILAR ADS size: " + annonces.size());
		// Si la liste est vide, on recherche les annonces uniquement par
		// mati�re

		if (annonces.isEmpty()) {
			annonces = userService.getMatchingAds(annonce.getSubject(), "");
			System.out.println("SIMILAR ADS #2 size: " + annonces.size());
		}

		/* Afficher uniquement les 5 premi�res annonces */

		if (annonces.size() < 6)
			model.addAttribute("annonces", annonces);

		else {
			List<Annonce> fiveFirstAds = new ArrayList<Annonce>();

			int counter = 0;

			while (counter < annonces.size() && counter <= 5) {

				fiveFirstAds.add(annonces.get(counter));
				counter++;
			}

			System.out.println("SIMILAR (5) ADS size: " + annonces.size());

			/* Chargment du model */

			model.addAttribute("annonces", fiveFirstAds);
		}

		model.addAttribute("annonce", annonce);

		return "adDetails";

	}

	/**
	 * Afficher la page de candidature
	 */

	@RequestMapping(value = "/candidater/{annonceID}", method = RequestMethod.GET)
	public String displayAnnonceApplicationPage(@PathVariable("annonceID") Long annonceID, final Model model) {

		/* Recherche Annonce */

		Annonce annonce = userService.getAdById(annonceID);

		if (annonce == null) {
			model.addAttribute("status", "Annonce introuvable!");
			return "statusPage";
		}

		/* Bean */

		model.addAttribute("annonceApplicationBean", new AnnonceApplication());
		model.addAttribute("annonce", annonce);

		return "annonceApplication";

	}
	
	
	/**
	 * 
	 * POSTER la candidature
	 */
	
	@RequestMapping(value="/candidater/{annonceID}", method = RequestMethod.POST)
	public String postAnnonceAppication(@PathVariable("annonceID") Long annonceID, 
			@ModelAttribute("AnnonceApplicationBean") @Valid AnnonceApplicationFormBean apb, 
			final BindingResult bindingResult, final Model model) {
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("ERRORS", "V�rifiez les champs des formulaires");
			return "annonceApplication";
		}
		
		/* Recherche Annonce */
		
		Annonce annonce = userService.getAdById(annonceID);
		
		if (annonce == null) {
			model.addAttribute("status", "Annonce introuvable!");
			return "statusPage";
		}
		
		
		/* Initialisation de la candidature */
		AnnonceApplicationFactory apFactory = new AnnonceApplicationFactory();
		AnnonceApplication annonceApplication = apFactory.createAnnonceApplication(annonce, apb);
		
		annonce.addApplication(annonceApplication);
		annonce = userService.updateAnnonce(annonce);
		
		if (annonce != null) {
			model.addAttribute("status", "Votre candidature a �t� envoy� avec succ�s!");
			return "redirect:/statusPage";
		}
		else {
			model.addAttribute("status", "Erreur! L'envoi de votre candidature a �chou�. Veuillez r�essayer plus tard!");
			return "redirect:/statusPage";
		}
	}
	
}
