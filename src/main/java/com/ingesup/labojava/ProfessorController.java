package com.ingesup.labojava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ingesup.labojava.bean.Professor;
import com.ingesup.labojava.service.ProfessorService;
import com.ingesup.labojava.service.ProfessorServiceImpl;

@Controller
@RequestMapping(value="/professors")
public class ProfessorController {
	
	private ProfessorService professorService = new ProfessorServiceImpl();
	
	@Autowired(required=true)
	@Qualifier(value="professorService")
	public void setProfessorService(ProfessorService ps) {
		this.professorService = ps;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listProfessors(Model model) {
		model.addAttribute("prof", new Professor());
		model.addAttribute("listProfessors", this.professorService.listProfessors());
		return "professors";
	}
	
}
