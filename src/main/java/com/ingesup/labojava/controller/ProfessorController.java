package com.ingesup.labojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.service.ProfessorService;
import com.ingesup.labojava.service.ProfessorServiceImpl;

@Controller
@RequestMapping(value="/professors")
@SessionAttributes("user")
public class ProfessorController {
	
	// Injection
	
	private ProfessorService professorService = new ProfessorServiceImpl();
	
	
	@Autowired(required=true)
	@Qualifier(value="professorService")
	public void setProfessorService(ProfessorService ps) {
		this.professorService = ps;
	}
	
	
	// Récupérer la liste de tous les professeurs
	
	@RequestMapping(method = RequestMethod.GET)
	public String listProfessors(Model model) {
		
		model.addAttribute("listProfessors", this.professorService.getProfessorList());
		return "professors";
	}
	
	
}
