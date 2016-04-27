package com.ingesup.labojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.bean.Student;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.UserFormBean;
import com.ingesup.labojava.service.StudentServiceImpl;
import com.ingesup.labojava.service.UserService;

@Controller
@RequestMapping(value = "/students")
@SessionAttributes("currentUser")
public class StudentController {

	private UserService userService = new StudentServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listStudents(Model model) {

		/* BEANS */

		model.addAttribute("userStatus", "Elèves");
		model.addAttribute("urlStatus", "students");
		model.addAttribute("userBean", new UserFormBean());

		return "students";
	}

	// Recherche d'un élève

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchProfessor(@RequestParam("fullName") final String fullName, final Model model) {

		/* BEANS */

		model.addAttribute("userStatus", "de l'élève");
		model.addAttribute("urlStatus", "students");
		model.addAttribute("name", fullName);
		model.addAttribute("userBean", new UserFormBean());

		// Spliting string

		String[] splited = fullName.split("\\s+");

		for (String s : splited)
			System.out.print("SPLITED : " + s + " -");

		System.out.println("");

		// Recherche des noms dans la BDD

		List<User> students = userService.getMatchingUsers(splited, "Student");
		model.addAttribute("listProfessors", students);

		return "professors";
	}
}
