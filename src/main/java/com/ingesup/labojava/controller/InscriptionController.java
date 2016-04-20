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
import org.springframework.web.context.request.WebRequest;

import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.factory.UserFactory;
import com.ingesup.labojava.form.FormsValidator;
import com.ingesup.labojava.form.InscriptionFormBean;
import com.ingesup.labojava.service.UserService;
import com.ingesup.labojava.service.UserServiceImpl;

@Controller
@SessionAttributes("currentUser")
public class InscriptionController {

	// Injection des services

	private UserService userService = new UserServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	
	/* INJECTION DES BEANS */
	
	@ModelAttribute("inscriptionBean")
	public InscriptionFormBean addInscriptionFormBean() {
		return new InscriptionFormBean();
	}
	

	// Affichage de la page d'inscription

	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscriptionPage(WebRequest request, final Model model) {

		// Chargement du bean pour le formulaire d'inscription
		// model.addAttribute("inscriptionBean", new InscriptionFormBean());
		
		
		/* Vérifions que l'user n'est pas déjà connecté */
		
		User currentUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);
		
		
		/* Déjà connecté */
		
		if (currentUser != null) {
			return "redirect:/profile";
		}
		
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

		/* On vérifie le mail */
		
		User user = userService.getUser(iFormBean.getEmail());
			
		if (user != null) {
			userStatus = "Ce mail est déjà utilisé!";
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
		
		model.addAttribute("currentUser", newUser);

		return "redirect:" + "profile/completeUserInfos";
	}

}
