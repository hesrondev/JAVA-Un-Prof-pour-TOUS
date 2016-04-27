package com.ingesup.labojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.FriendRequestBean;
import com.ingesup.labojava.form.UserFormBean;
import com.ingesup.labojava.service.UserService;
import com.ingesup.labojava.service.UserServiceImpl;

@Controller
@SessionAttributes("currentUser")
public class UserSearchController {

	// Injection des services

	private UserService userService = new UserServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	/* INJECTION bean */

	@ModelAttribute("userBean")
	public UserFormBean addUserBean() {
		return new UserFormBean();
	}

	@ModelAttribute("requestBean")
	public FriendRequestBean addFriendRequest() {
		return new FriendRequestBean();
	}

	// Afficher la page de résultats

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String userSearchPage(@RequestParam("fullName") final String fullName, final Model model) {

		/* BEANS */

		model.addAttribute("name", fullName);

		// Spliting string

		String[] splited = fullName.split("\\s+");

		for (String s : splited)
			System.out.print("SPLITED : " + s + " -");

		System.out.println("");

		// Recherche des noms dans la BDD

		List<User> users = userService.getMatchingUsers(splited, "User");
		model.addAttribute("listUsers", users);

		return "usersPage";

	}

}
