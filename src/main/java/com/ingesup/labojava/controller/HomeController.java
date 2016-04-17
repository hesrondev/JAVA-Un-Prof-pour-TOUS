package com.ingesup.labojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.bean.FriendRequest;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.AnnonceFormBean;
import com.ingesup.labojava.form.Filter;
import com.ingesup.labojava.form.FilterCategory;
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
	
	
	/* Page d'accueil */

	@RequestMapping(value={"/", "/home**"}, method = RequestMethod.GET)
	public String homePage(final Model model) {
		
		/* CHARGEMENT DES BEANS */
		
		model.addAttribute("adBean", new AnnonceFormBean());
		model.addAttribute("usersCount", userService.countUsers());
		model.addAttribute("latestUsers", userService.getLatestUsers(10));
		model.addAttribute("latestAnnonces", userService.getLatestAnnonces(5));
		
		/* afficher uniquement les filtres concernées */

		List<Filter> allFilters = Utilities.createFilters(userService.getAllAds());
		model.addAttribute("locationFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.LOCATION));
		model.addAttribute("subjectFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.SUBJECT));
		model.addAttribute("levelFilters", Utilities.getFiltersByCategory(allFilters, FilterCategory.LEVEL));
		
		return "home";
	}
	
	/* Page du GUIDE */
	
	@RequestMapping(value="/guide", method = RequestMethod.GET)
	public String displayGuidePage() {
		return "guide";
	}
	
	
	/**
	 * PAGE DE TEST * */
	
	@RequestMapping(value="/test-page")
	public String displayTestPage(final Model model) {
		
		model.addAttribute("userList", userService.getAllUsers());
		return "test-page";
	}
	
	/**
	 * PAGE DE RESTRICTION */
	
	@RequestMapping(value="/restriction")
	public String displayRestrictionPage(final Model model) {
		
		model.addAttribute("statusMessage", "visiter cette page");
		return "restriction-page";
	}
	
	
}
