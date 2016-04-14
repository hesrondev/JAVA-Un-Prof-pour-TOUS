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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.factory.AnnonceFactory;
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

	
	/* Rechercher une annonce
	 * 
	 */

	@RequestMapping(value = "/recherche", method = RequestMethod.GET)
	public String searchAnnonces(@RequestParam("subject") final String subject, 
			@RequestParam("location") final String location, final Model model) {


		annonces = userService.getMatchingAds(subject, location);
		
		/* afficher le bean du formulaire de rechere */
		
		model.addAttribute("adBean", new AnnonceFormBean());
		
		/* afficher uniquement les filtres concern�es */

		List<Filter> allFilters = createFilters(annonces);
		model.addAttribute("statusFilters", getFiltersByCategory(allFilters, FilterCategory.STATUS));
		model.addAttribute("locationFilters", getFiltersByCategory(allFilters, FilterCategory.LOCATION));
		model.addAttribute("subjectFilters", getFiltersByCategory(allFilters, FilterCategory.SUBJECT));
		model.addAttribute("levelFilters", getFiltersByCategory(allFilters, FilterCategory.LEVEL));

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

		List<Filter> allFilters = createFilters(annonces);
		model.addAttribute("statusFilters", getFiltersByCategory(allFilters, FilterCategory.STATUS));
		model.addAttribute("locationFilters", getFiltersByCategory(allFilters, FilterCategory.LOCATION));
		model.addAttribute("subjectFilters", getFiltersByCategory(allFilters, FilterCategory.SUBJECT));
		model.addAttribute("levelFilters", getFiltersByCategory(allFilters, FilterCategory.LEVEL));

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

		List<Filter> allFilters = createFilters(annonces);

		mView.addObject("statusFilters", getFiltersByCategory(allFilters, FilterCategory.STATUS));
		mView.addObject("locationFilters", getFiltersByCategory(allFilters, FilterCategory.LOCATION));
		mView.addObject("subjectFilters", getFiltersByCategory(allFilters, FilterCategory.SUBJECT));
		mView.addObject("levelFilters", getFiltersByCategory(allFilters, FilterCategory.LEVEL));

		mView.setViewName("annonces");

		return mView;
	}
	
	
	// Affichage des d�tails d'une annonce
	
	@RequestMapping(value = "/{adID}", method = RequestMethod.GET)
	public String displayAdDetails(@PathVariable("adID") final Long ID, final Model model) {
		
		
		/* Recherche de l'annonce */
		
		Annonce annonce = userService.getAdById(ID);
		
		if (annonce != null) {
		
			/* R�cup�ration de la liste des annonces similaires */
			
			annonces = userService.getMatchingAds(annonce.getSubject(), annonce.getLocation());
			
			System.out.println("SIMILAR ADS size: " +annonces.size());
			// Si la liste est vide, on recherche les annonces uniquement par mati�re
			
			if (annonces.isEmpty()) {
				annonces = userService.getMatchingAds(annonce.getSubject(), "");
				
				System.out.println("SIMILAR ADS #2 size: " +annonces.size());
			}
			
			/* Afficher uniquement les 5 premi�res offres*/
			
			if (annonces.size() < 6) 
				model.addAttribute("annonces", annonces);
			
			else {
				List<Annonce> fiveFirstAds = new ArrayList<Annonce>();
				
				int counter = 0;
				
				while(counter < annonces.size() && counter <= 5) {
					
					fiveFirstAds.add(annonces.get(counter));
					counter++;
				}
				
				System.out.println("SIMILAR (5) ADS size: " +annonces.size());
				
				/* Chargment du model */
				
				model.addAttribute("annonces", fiveFirstAds);
			}
			
			
			model.addAttribute("annonce", annonce);
			
			return "adDetails";
		}
		
		else
			return "confirmationPage/{NotFound}";
	}
	
	
	/* Charge les �l�ments de la page d'annonce
	
	private ModelAndView chargeAnnoncesOnPage(List<Annonce> annonces) {
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("adBean", new AnnonceFormBean());
		model.addObject("annonces", annonces);
		
		// afficher uniquement les filtres concern�es

		List<Filter> allFilters = createFilters(annonces);

		model.addObject("statusFilters", getFiltersByCategory(allFilters, FilterCategory.STATUS));
		model.addObject("locationFilters", getFiltersByCategory(allFilters, FilterCategory.LOCATION));
		model.addObject("subjectFilters", getFiltersByCategory(allFilters, FilterCategory.SUBJECT));
		model.addObject("levelFilters", getFiltersByCategory(allFilters, FilterCategory.LEVEL));
		
		return model;
		
	} */
	
	
	// Renvoie la liste d'une cat�gorie de liste parmi tous les filtres de
		// 'allFilters'

	private List<Filter> getFiltersByCategory(List<Filter> allFilters, FilterCategory fcat) {

		List<Filter> filters = new ArrayList<Filter>();
		for (Filter f : allFilters) {

			if (f.geteCategory().equals(fcat))
				filters.add(f);
		}
		return filters;
	}
	
	
	
	// Initialise tous les filtres en fonctions des annonces
		// On a aussi besoin de la liste des utilisateurs pour connaitre leurs
		// status

		private List<Filter> createFilters(List<Annonce> annonces) {
			List<Filter> filters = new ArrayList<Filter>();

			System.out.println("//////////////// Creating filters... -- annonces : " + annonces.size());

			for (Annonce ad : annonces) {

				// On parcourt la liste des filtres pour chercher les filtres

				// index des �l�ments dans la liste filters [-1 = pas trouv�, > -1 =
				// index = pr�sent]
				int iStatus = -1;
				int iLocation = -1;
				int iLevel = -1;
				int iSubject = -1;

				for (int i = 0; i < filters.size(); i++) {

					Filter f = filters.get(i);

					// On compare les valeurs des diff�rents attributs de l'annonce
					// � la valeur du filtre
					// Si on trouve une valeur �gale, on l'incr�mente sinon on va le
					// cr�er

					if (ad.getUser().getType().equals(f.getValue())) {
						f.counterPlus();
						System.out.println("--STATUS-- " + ad.getUser().getType() + " -- COUNTER : " + f.getCounter());
						iStatus = i;
					}

					if (ad.getLocation().equals(f.getValue())) {
						f.counterPlus();
						iLocation = i;
						System.out.println("--LOCATION-- " + ad.getLocation() + " -- COUNTER : " + f.getCounter());
					}

					else if (ad.getSubject().equals(f.getValue())) {
						f.counterPlus();
						iSubject = i;
						System.out.println("--SUBJECT-- " + ad.getSubject() + " -- COUNTER : " + f.getCounter());
					}

					else if (ad.getLevel().equals(f.getValue())) {
						f.counterPlus();
						iLevel = i;
						System.out.println("--LEVEL-- " + ad.getLevel() + " -- COUNTER : " + f.getCounter());
					}
				}

				// Si l'index est toujours � -1, on ajoute le filtre
				if (iStatus == -1) {
					filters.add(new Filter(FilterCategory.STATUS, ad.getUser().getType()));
					System.out.println("Adding STATUS FILTER...");
				}

				if (iLocation == -1) {
					filters.add(new Filter(FilterCategory.LOCATION, ad.getLocation()));
					System.out.println("Adding LOCATION FILTER...");
				}

				if (iSubject == -1) {
					filters.add(new Filter(FilterCategory.SUBJECT, ad.getSubject()));
					System.out.println("Adding subject FILTER...");
				}

				if (iLevel == -1) {
					filters.add(new Filter(FilterCategory.LEVEL, ad.getLevel()));
					System.out.println("Adding level FILTER...");
				}
			}

			System.out.println("////////////ALL " + filters.size());

			return filters;
		}
}
