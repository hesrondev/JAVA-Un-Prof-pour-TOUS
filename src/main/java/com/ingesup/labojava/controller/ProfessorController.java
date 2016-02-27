package com.ingesup.labojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.service.ProfessorServiceImpl;
import com.ingesup.labojava.service.UserService;

@Controller
@RequestMapping(value="/professors")
@SessionAttributes("user")
public class ProfessorController {
	
	// Injection
	
	private UserService userService = new ProfessorServiceImpl();
	
	
	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	
	// Récupérer la liste de tous les professeurs
	
	@RequestMapping(method = RequestMethod.GET)
	public String listProfessors(Model model) {
		
		model.addAttribute("listProfessors", this.userService.getAllProfessors());
		return "professors";
	}
	
	
}
