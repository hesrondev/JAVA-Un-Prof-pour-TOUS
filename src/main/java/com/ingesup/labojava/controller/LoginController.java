package com.ingesup.labojava.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.form.LoginFormBean;
import com.ingesup.labojava.form.UserFormBean;
import com.ingesup.labojava.service.UserService;
import com.ingesup.labojava.service.UserServiceImpl;
import com.ingesup.labojava.utils.Crypto;

@Controller
@SessionAttributes("currentUser")
public class LoginController {

	// Injection des services

	private UserService userService = new UserServiceImpl();

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	/* INJECTION bean LOGIN */

	@ModelAttribute("loginBean")
	public LoginFormBean addLoginFormBean() {
		return new LoginFormBean();
	}

	@ModelAttribute("userBean")
	public UserFormBean addUserBean() {
		return new UserFormBean();
	}

	// Affichage de la page de connexion d'un utilisateur

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(WebRequest request, final Model model,
			@CookieValue(value = "u_email", defaultValue = "") String email,
			@CookieValue(value = "u_pass", defaultValue = "") String pass) {

		/* V�rifions que l'user n'est pas d�j� connect� */

		User currentUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);

		/* D�j� connect� */

		if (currentUser != null) {
			return "redirect:/profile";
		}

		// Si non on vérifid les cookies

		if (!email.isEmpty() && !pass.isEmpty()) {

			currentUser = userService.getUser(email, pass);
			if (currentUser != null) {
				model.addAttribute("currentUser", currentUser);

				return "redirect:/profile";
			}
		}

		return "login";
	}

	// Traitement de la requ�te POST de connexion

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(@ModelAttribute("loginBean") @Valid final LoginFormBean lFormBean,
			final BindingResult bindingResult, HttpServletResponse response) {

		ModelAndView mView = new ModelAndView();

		if (bindingResult.hasErrors()) {

			String loginStatus = "Adresse mail ou mot de passe invalides!";

			mView.addObject("loginStatus", loginStatus);
			mView.setViewName("login");
			return mView;

		}

		// On cherche l'utilisateur dans la base de données
		// On cherche avec le mot de passe crypté

		User user = userService.getUser(lFormBean.getEmail(), Crypto.crypter(lFormBean.getPassword()));

		if (user != null) {

			// Si remember me est coché, on créè un cookie pour le stocker
			// pendant 1j

			if (lFormBean.isRememberMe()) {
				Cookie em = new Cookie("u_email", user.getEmail());
				Cookie mdp = new Cookie("u_pass", user.getPassword());
				em.setMaxAge(86400);
				mdp.setMaxAge(86400);

				response.addCookie(em);
				response.addCookie(mdp);
			}

			// Test si c'est un �tudiant ou un professor pour le caster

			mView.addObject("currentUser", user);
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
	 * Deconnexion
	 */

	@RequestMapping(value = "/logout")
	public String endSession(SessionStatus sessionStatus,
			@CookieValue(value = "u_email", defaultValue = "") String email,
			@CookieValue(value = "u_pass", defaultValue = "") String pass, HttpServletResponse resp) {
		
		
		// Suppression des cookies
		
		if (!email.isEmpty()) {
			Cookie em = new Cookie("u_email", "");
			em.setMaxAge(0);
			resp.addCookie(em);
		}
		
		if (!pass.isEmpty()) {
			Cookie em = new Cookie("u_pass", "");
			em.setMaxAge(0);
			resp.addCookie(em);
		}
		

		sessionStatus.setComplete();
		return "redirect:/login";
	}

}
