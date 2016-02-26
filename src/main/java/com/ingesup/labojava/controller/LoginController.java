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
import org.springframework.web.servlet.ModelAndView;

import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.form.LoginFormBean;
import com.ingesup.labojava.service.ProfessorService;
import com.ingesup.labojava.service.ProfessorServiceImpl;
import com.ingesup.labojava.service.StudentService;
import com.ingesup.labojava.service.StudentServiceImpl;

@Controller
@SessionAttributes("user")
public class LoginController {

	// Injection des services

	private ProfessorService professorService = new ProfessorServiceImpl();
	private StudentService studentService = new StudentServiceImpl();
	
	
	@Autowired(required = true)
	@Qualifier(value = "professorService")
	public void setProfessorService(ProfessorService ps) {
		this.professorService = ps;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "studentService")
	public void setStudentService(StudentService ss) {
		this.studentService = ss;
	}

	// Connexion d'un utilisateur

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(final Model model) {

		model.addAttribute("loginBean", new LoginFormBean());
		return "login";
	}

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
		
		Professor prof = professorService.getProfessor(lFormBean.getEmail(), lFormBean.getPassword());
		Student student = studentService.getStudent(lFormBean.getEmail(), lFormBean.getPassword()); 
		
		
		// Si c'est un prof
		if (prof != null) {
			mView.addObject("user", prof);
			mView.setViewName("redirect:/home");
			
			return mView;
		}
		
		// Si c'est un élève
		else if (student != null) {
			mView.addObject("user", student);
			mView.setViewName("redirect:/home");
			
			return mView;
		}
		
		// Sinon

		String loginStatus = "Identifiants incorrects!";			
		mView.addObject("loginStatus", loginStatus);
		mView.setViewName("login");
		return mView;		

	}

}
