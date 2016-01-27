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

import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.factory.ProfessorFactory;
import com.ingesup.labojava.factory.StudentFactory;
import com.ingesup.labojava.form.FormsValidator;
import com.ingesup.labojava.form.InscriptionFormBean;
import com.ingesup.labojava.service.ProfessorService;
import com.ingesup.labojava.service.ProfessorServiceImpl;
import com.ingesup.labojava.service.StudentService;
import com.ingesup.labojava.service.StudentServiceImpl;

@Controller
@SessionAttributes("user")
public class InscriptionController {

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

		// Factoring...
		
		System.out.println("STATUT**** : " + iFormBean.getStatus());
		
		if (iFormBean.getStatus().equals("professor")) {
			ProfessorFactory professorFactory = new ProfessorFactory();
			Professor prof = professorFactory.createProfessor(iFormBean);
			this.professorService.addProfessor(prof);
		}
		
		else {
			StudentFactory studentFactory = new StudentFactory();
			Student student = studentFactory.createStudent(iFormBean);
			this.studentService.addStudent(student);
		}

		return "redirect:" + "/home";
	}

}
