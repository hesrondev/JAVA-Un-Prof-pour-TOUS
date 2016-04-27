package com.ingesup.labojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.bean.FriendRequest;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.AnnonceFormBean;
import com.ingesup.labojava.form.Filter;
import com.ingesup.labojava.form.FilterCategory;
import com.ingesup.labojava.form.FriendRequestBean;
import com.ingesup.labojava.form.UserFormBean;
import com.ingesup.labojava.service.UserService;
import com.ingesup.labojava.service.UserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("currentUser")
public class HomeController {
	
	
	/* INJECTION DE DEPENDANCES */
	
	private UserService userService = new UserServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	@ModelAttribute("requestBean")
	public FriendRequestBean addFriendRequest() {
		return new FriendRequestBean();
	}
	
	@ModelAttribute("userBean") 
	public UserFormBean addUserBean() {
		return new UserFormBean();
	}
	
	
	/* Page d'accueil */

	@RequestMapping(value={"/", "/home**"}, method = RequestMethod.GET)
	public String homePage(final Model model) {
		
		/* CHARGEMENT DES BEANS */
		
		model.addAttribute("adBean", new AnnonceFormBean());
		model.addAttribute("usersCount", userService.countUsers());
		model.addAttribute("latestUsers", userService.getLatestUsers(10));
		model.addAttribute("latestAnnonces", userService.getLatestAnnonces(5));
		
		/* afficher uniquement les filtres concernï¿½es */

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
	
	/* Page contact du footer */
		
		@RequestMapping(value="/contact", method = RequestMethod.GET)
		public String displayContactPage() {
			return "contact";
		}
		
		/* Page à propos du footer */
		
		@RequestMapping(value="/about", method = RequestMethod.GET)
		public String displayAboutPage() {
			return "about";
		}
		
	/* Page Développeurs du footer */
		
		@RequestMapping(value="/developpers", method = RequestMethod.GET)
		public String displayDevPage() {
			return "developpers";
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
	public String displayRestrictionPage(@RequestParam(value="statusMessage", required=false) String statusPage, final Model model) {
		
		String status = statusPage;
		
		if (status.isEmpty())
			status = "visiter cette page";
		
		model.addAttribute("statusMessage", status);
		return "restriction-page";
	}
	
	@RequestMapping(value="/status-page")
	public String displayStatusPage(@RequestParam("statusMessage") String statusMessage,
			final Model model) {
		
		model.addAttribute("statusMessage", statusMessage);
		return "status-page";
	}
	
}
