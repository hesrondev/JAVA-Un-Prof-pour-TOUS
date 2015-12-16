package com.ingesup.labojava.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.factory.ProfessorFactory;
import com.ingesup.labojava.form.FormsValidator;
import com.ingesup.labojava.form.InscriptionFormBean;
import com.ingesup.labojava.form.LoginFormBean;
import com.ingesup.labojava.service.ProfessorService;
import com.ingesup.labojava.service.ProfessorServiceImpl;

@Controller
@RequestMapping(value="/professors")
public class ProfessorController {
	
	private ProfessorService professorService = new ProfessorServiceImpl();
	
	@Autowired(required=true)
	@Qualifier(value="professorService")
	public void setProfessorService(ProfessorService ps) {
		this.professorService = ps;
	}

	
	// R�cup�rer la liste de tous les professeurs
	
	@RequestMapping(method = RequestMethod.GET)
	public String listProfessors(Model model) {
		
		// Chargement du bean pour le formulaire d'inscription
		model.addAttribute("inscriptionBean", new InscriptionFormBean());
		model.addAttribute("listProfessors", this.professorService.listProfessors());
		return "professors";
	}
	
	
	// Inscription d'un professeur
	
	@RequestMapping(value="/inscription", method = RequestMethod.POST)
	public String addProfessor(@ModelAttribute("inscriptionBean") @Valid final InscriptionFormBean iFormBean, 
			final BindingResult bindingResult, final Model model) {
		
		String profStatus = "";
		
		if (bindingResult.hasErrors()) {
			
			profStatus = "Donn�es du formulaire invalides!!! V�rifiez votre saisie.";
			model.addAttribute("profStatus", profStatus);
			return "professors";
		}
		
		// Validateur de formulaire
		FormsValidator fValidator = new FormsValidator();
		
		// Si le formulaire n'est pas valide
		if (!fValidator.isValidInscriptionForm(iFormBean)) {
			profStatus = "Donn�es du formulaire invalides!!! V�rifiez votre saisie.";
			model.addAttribute("profStatus", profStatus);
			return "professors";
		}
		
		// ProfFactory
		ProfessorFactory professorFactory = new ProfessorFactory();
		Professor prof = professorFactory.createProfessor(iFormBean);
		this.professorService.addProfessor(prof);
		
		profStatus = "Vous �tes inscrits!";
		//model.addAttribute("profStatus", profStatus);
		
		return "redirect:"+ "/professors";
	}
	
	
	// Connexion d'un professeur
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(final Model model) {
		
		model.addAttribute("loginBean", new LoginFormBean());
		return "login";		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginProfessor(@ModelAttribute("loginBean") @Valid final LoginFormBean lFormBean,
			final BindingResult bindingResult, final Model model) {
		
		String loginStatus = "";
		
		if (bindingResult.hasErrors()) {
			
			loginStatus = "Adresse mail ou mot de passe invalides!";
			model.addAttribute("loginStatus", loginStatus);
			return "login";
		}
		
		Professor prof = professorService.getProfessor(lFormBean.getEmail(), lFormBean.getPassword());
		model.addAttribute("loginStatus", prof);
		
		return "home";
		
	}
	
	
}