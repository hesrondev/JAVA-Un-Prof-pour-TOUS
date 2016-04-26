package com.ingesup.labojava.controller;

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

import com.ingesup.labojava.bean.CourseEvent;
import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.CourseEventFormBean;
import com.ingesup.labojava.form.UserFormBean;
import com.ingesup.labojava.service.UserService;
import com.ingesup.labojava.service.UserServiceImpl;

@Controller
@SessionAttributes("currentUser")
public class PlanningController {
	
	

	// Injection des services

	private UserService userService = new UserServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	
	// Injection des beans
	
	@ModelAttribute("courseEventBean")
	public CourseEventFormBean addCourseEventBean() {
		return new CourseEventFormBean();
	}
	
	@ModelAttribute("userBean") 
	public UserFormBean addUserBean() {
		return new UserFormBean();
	}
	
	
	// Affichage de la page d'ajout d'un événement
	
	@RequestMapping(value="/profile/planning/add-event", method = RequestMethod.GET)
	public String displayForm(WebRequest request, Model model) {
		
User currentUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);
		
		if (currentUser == null) {
			// Restriction connexion
			return "redirect:/login";
		}
		
		/* Réservé aux professeurs */
		
		if (currentUser.getClass() != Professor.class) {
			model.addAttribute("statusMessage", "Cette action est réservé aux professeurs!");
			return "redirect:/status-page";
		}
		
		return "private/createCourseEvent";
	}
	
	@RequestMapping(value="/profile/planning/add-event", method = RequestMethod.POST)
	public String createCourseEventHandler(WebRequest request, @ModelAttribute("courseEventBean") CourseEventFormBean cefb, final BindingResult br, Model model) {
		
		// On vérifie la session
		
		User currentUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);
		
		if (currentUser == null) {
			// Restriction connexion
			model.addAttribute("statusMessage", "ajouter un cours au planning");
			return "redirect:/restriction";
		}
		
		
		/* Réservé aux professeurs */
		
		if (currentUser.getClass() != Professor.class) {
			model.addAttribute("statusMessage", "Cette action est réservé aux professeurs!");
			return "redirect:/status-page";
		}
		
		
		// On vérifie la validité du formulaire
		
		if (br.hasErrors()) {
			model.addAttribute("errorStatus", "Tous les champs sont obligatoires");
			return "private/createCourseEvent";
		}
		
		// Si toutes les infos sont cohérentes
		
		CourseEvent course = cefb.createEvent();
		
		((Professor) currentUser).addCourseEvent(course);		
		
		// MAJ du professeur
		
		userService.updateUser(currentUser);
		
		model.addAttribute("currentUser", userService.getUser(currentUser.getId()));
		
		return "redirect:/profile";
	}
}
