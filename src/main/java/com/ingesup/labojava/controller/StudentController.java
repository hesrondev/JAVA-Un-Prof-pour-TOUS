package com.ingesup.labojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.service.StudentService;
import com.ingesup.labojava.service.StudentServiceImpl;

@Controller
@RequestMapping(value="/students")
@SessionAttributes("user")
public class StudentController {
	
	private StudentService studentService = new StudentServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "studentService")
	public void setStudentService(StudentService ss) {
		this.studentService = ss;
	}

	
	// Récupérer la liste de tous les élèves
	
	@RequestMapping(method = RequestMethod.GET)
	public String listStudents(Model model) {
		
		model.addAttribute("listStudents", this.studentService.listStudents());
		return "students";
	}
}
