package com.ingesup.labojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.UserFormBean;
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
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String listProfessors(Model model) {
		
		/* BEANS */
		
		model.addAttribute("userStatus", "Professeur");
		model.addAttribute("urlStatus", "professors");
		model.addAttribute("userBean", new UserFormBean());
		
		
		return "professors";
	}
	
	// Recherche d'un professeur
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String searchProfessor(@RequestParam("fullName") final String fullName, final Model model) {
		
		/* BEANS */
		
		model.addAttribute("userStatus", " du professeur");
		model.addAttribute("urlStatus", "professors");
		model.addAttribute("name", fullName);
		model.addAttribute("userBean", new UserFormBean());
		
		// Spliting string
		
		String[] splited = fullName.split("\\s+");
		
		for(String s : splited)
			System.out.print("SPLITED : " +s+ " -");
		
		System.out.println("");
		
		
		// Recherche des noms dans la BDD
		
		List<User> professors = userService.getMatchingUsers(splited, "Professor");
		model.addAttribute("listProfessors", professors);
		
		return "professors";
	}
	
	
}
