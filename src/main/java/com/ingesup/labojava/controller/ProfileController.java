package com.ingesup.labojava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.bean.Professor;

@Controller
@SessionAttributes("user")
public class ProfileController {
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String profilePage(final Model model) {

		return "profile";
	}

}
