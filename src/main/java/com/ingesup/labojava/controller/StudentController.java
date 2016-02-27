package com.ingesup.labojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.service.StudentServiceImpl;
import com.ingesup.labojava.service.UserService;

@Controller
@RequestMapping(value="/students")
@SessionAttributes("user")
public class StudentController {
	
	private UserService userService = new StudentServiceImpl();
	
	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	
	// Récupérer la liste de tous les élèves
	
	@RequestMapping(method = RequestMethod.GET)
	public String listStudents(Model model) {
		
		model.addAttribute("listStudents", this.userService.getAllStudents());
		return "students";
	}
}
