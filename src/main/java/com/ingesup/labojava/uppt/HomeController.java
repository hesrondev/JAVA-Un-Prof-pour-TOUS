package com.ingesup.labojava.uppt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(value="/accueil", method = RequestMethod.GET)
	public String indexPage() {
		return "home";
	}
	
	
}
