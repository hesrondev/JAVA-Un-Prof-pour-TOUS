package com.ingesup.labojava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("user")
public class HomeController {
	

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String indexPage() {
		return "home";
	}
	
	@RequestMapping(value="/guide", method = RequestMethod.GET)
	public String displayGuidePage() {
		return "guide";
	}
	
	
}
