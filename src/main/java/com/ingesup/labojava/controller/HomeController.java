package com.ingesup.labojava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.form.AnnonceFormBean;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("user")
public class HomeController {
	

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
	
	
}
