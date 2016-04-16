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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.LoginFormBean;
import com.ingesup.labojava.service.UserService;
import com.ingesup.labojava.service.UserServiceImpl;

@Controller
@SessionAttributes("user")
public class LoginController {

	// Injection des services

	private UserService userService = new UserServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	
	// Affichage de la page de connexion d'un utilisateur

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(final Model model) {

		model.addAttribute("loginBean", new LoginFormBean());
		return "login";
	}

	
	// Traitement de la requête POST de connexion
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(@ModelAttribute("loginBean") @Valid final LoginFormBean lFormBean,
			final BindingResult bindingResult) {
		
		ModelAndView mView = new ModelAndView();

		if (bindingResult.hasErrors()) {

			String loginStatus = "Adresse mail ou mot de passe invalides!";
			
			mView.addObject("loginStatus", loginStatus);
			mView.setViewName("login");
			return mView;
			
		}

		
		// On cherche l'utilisateur dans la base de données
		
		User user = userService.getUser(lFormBean.getEmail(), lFormBean.getPassword());
		
		if (user != null) {
			
			// Test si c'est un étudiant ou un professor pour le caster
			
			mView.addObject("user", user);
			mView.setViewName("redirect:/profile");
			
			return mView;
		}
		
		// Sinon

		String loginStatus = "Identifiants incorrects!";			
		mView.addObject("loginStatus", loginStatus);
		mView.setViewName("login");
		return mView;		

	}
	
	/**
	 * Deconnexion */
	
	@RequestMapping(value="/logout")
	public String endSession(SessionStatus sessionStatus) {
		
		sessionStatus.setComplete();
		return "redirect:/login";
	}

}
