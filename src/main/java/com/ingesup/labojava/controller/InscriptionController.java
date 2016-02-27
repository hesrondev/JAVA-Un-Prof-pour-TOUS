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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.factory.UserFactory;
import com.ingesup.labojava.form.FormsValidator;
import com.ingesup.labojava.form.InscriptionFormBean;
import com.ingesup.labojava.service.UserService;
import com.ingesup.labojava.service.UserServiceImpl;

@Controller
@SessionAttributes("user")
public class InscriptionController {

	// Injection des services

	private UserService userService = new UserServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	// Affichage de la page d'inscription

	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscriptionPage(final Model model) {

		// Chargement du bean pour le formulaire d'inscription
		model.addAttribute("inscriptionBean", new InscriptionFormBean());
		return "inscription";
	}

	
	// Traitement de la requête POST d'inscription
	
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public String inscriptionPost(@ModelAttribute("inscriptionBean") @Valid final InscriptionFormBean iFormBean,
			final BindingResult bindingResult, final Model model) {

		String userStatus = "";

		if (bindingResult.hasErrors()) {

			userStatus = "Données du formulaire invalides!!! Vérifiez votre saisie.";
			model.addAttribute("userStatus", userStatus);
			return "inscription";
		}

		// Validateur de formulaire
		FormsValidator fValidator = new FormsValidator();

		// Si le formulaire n'est pas valide
		if (!fValidator.isValidInscriptionForm(iFormBean)) {
			userStatus = "Données du formulaire invalides!!! Vérifiez votre saisie.";
			model.addAttribute("userStatus", userStatus);
			return "inscription";
		}

		
		// Factoring user
		
		UserFactory userFactory = new UserFactory();
		User newUser = null;
		
		if (iFormBean.getStatus().equals("professor")) 
			newUser = userFactory.createProfessor(iFormBean);
			
		else
			newUser = userFactory.createStudent(iFormBean);
		
		if (newUser != null)
			userService.addUser(newUser);

		return "redirect:" + "/home";
	}

}
