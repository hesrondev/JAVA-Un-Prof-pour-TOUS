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
import com.ingesup.labojava.form.LoginFormBean;
import com.ingesup.labojava.service.ProfessorService;
import com.ingesup.labojava.service.ProfessorServiceImpl;

@Controller
public class LoginController {

	// Injection des services

	private ProfessorService professorService = new ProfessorServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "professorService")
	public void setProfessorService(ProfessorService ps) {
		this.professorService = ps;
	}

	// Connexion d'un utilisateur

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(final Model model) {

		model.addAttribute("loginBean", new LoginFormBean());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute("loginBean") @Valid final LoginFormBean lFormBean,
			final BindingResult bindingResult, final Model model) {

		String loginStatus = "";

		if (bindingResult.hasErrors()) {

			loginStatus = "Adresse mail ou mot de passe invalides!";
			model.addAttribute("loginStatus", loginStatus);
			return "login";
		}

		Professor prof = professorService.getProfessor(lFormBean.getEmail(), lFormBean.getPassword());
		
		if (prof == null) {
			loginStatus = "Identifiants incorrects!";
			model.addAttribute("loginStatus", loginStatus);
			
			return "login";
		}
			
		model.addAttribute("loginStatus", prof);

		return "redirect:" + "/profile";

	}

}
