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
import com.ingesup.labojava.service.ProfessorService;
import com.ingesup.labojava.service.ProfessorServiceImpl;

@Controller
public class InscriptionController {

	// Injection des services

	private ProfessorService professorService = new ProfessorServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "professorService")
	public void setProfessorService(ProfessorService ps) {
		this.professorService = ps;
	}

	// Inscription d'un professeur
	
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscriptionPage(final Model model) {

		// Chargement du bean pour le formulaire d'inscription
		model.addAttribute("inscriptionBean", new InscriptionFormBean());
		return "inscription";
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public String inscriptionPost(@ModelAttribute("inscriptionBean") @Valid final InscriptionFormBean iFormBean,
			final BindingResult bindingResult, final Model model) {

		String profStatus = "";

		if (bindingResult.hasErrors()) {

			profStatus = "Données du formulaire invalides!!! Vérifiez votre saisie.";
			model.addAttribute("profStatus", profStatus);
			return "inscription";
		}

		// Validateur de formulaire
		FormsValidator fValidator = new FormsValidator();

		// Si le formulaire n'est pas valide
		if (!fValidator.isValidInscriptionForm(iFormBean)) {
			profStatus = "Données du formulaire invalides!!! Vérifiez votre saisie.";
			model.addAttribute("profStatus", profStatus);
			return "inscription";
		}

		// ProfFactory
		ProfessorFactory professorFactory = new ProfessorFactory();
		Professor prof = professorFactory.createProfessor(iFormBean);
		this.professorService.addProfessor(prof);

		return "redirect:" + "/professors";
	}

}
