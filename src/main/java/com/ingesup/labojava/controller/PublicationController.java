package com.ingesup.labojava.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.bean.AnnonceApplication;
import com.ingesup.labojava.bean.Publication;
import com.ingesup.labojava.bean.User;
import com.ingesup.labojava.factory.AnnonceApplicationFactory;
import com.ingesup.labojava.factory.AnnonceFactory;
import com.ingesup.labojava.factory.PublicationFactory;
import com.ingesup.labojava.form.AnnonceApplicationFormBean;
import com.ingesup.labojava.form.AnnonceFormBean;
import com.ingesup.labojava.form.Filter;
import com.ingesup.labojava.form.FilterCategory;
import com.ingesup.labojava.form.PublicationFormBean;
import com.ingesup.labojava.service.UserService;
import com.ingesup.labojava.service.UserServiceImpl;

@Controller
@RequestMapping("/profile/publications")
@SessionAttributes("currentUser")
public class PublicationController {

		// List de publications

		PublicationFormBean publicationfb = new PublicationFormBean();
		List<Publication> publications = new ArrayList<Publication>();

		// Injection des services

		private UserService userService = new UserServiceImpl();

		@Autowired(required = true)
		@Qualifier(value = "userService")
		public void setUserService(UserService us) {
			this.userService = us;
		}

		// Affichage de la page de création d'une publication

		@RequestMapping(value = "/profile/publications", method = RequestMethod.GET)
		public String displayPubliCreationPage(final Model model) {

			model.addAttribute("publiBean", new PublicationFormBean());
			return "createPubli";
		}

		// Méthode POST d'une annonce

		@RequestMapping(value = "/profile/publications", method = RequestMethod.POST)
		public ModelAndView createPubliPost(WebRequest request,
				@ModelAttribute("publiBean") @Valid final PublicationFormBean publiFormBean, final BindingResult bindingResult) {

			ModelAndView mView = new ModelAndView();

			// S'il y'a des erreurs

			if (bindingResult.hasErrors()) {

				String formStatus = "Erreur: vérifiez les champs!";

				mView.addObject("formStatus", formStatus);
				mView.setViewName("createPubli");
				return mView;
			}

			// Vérification de l'utilisateur

			User currentUser = (User) request.getAttribute("currentUser", WebRequest.SCOPE_SESSION);

			if (currentUser == null) {

				String formStatus = "Vous n'êtes pas connecté! Connectez-vous pour publier une publication.";

				mView.addObject("notConnectedStatus", formStatus);
				mView.setViewName("createPubli");
				return mView;
			}

			// Création de l'annonce

			PublicationFactory publicationFactory = new PublicationFactory();
			Publication publi = publicationFactory.createPublication(publiFormBean);

			currentUser.addPublication(publi);
			publi.setUser(currentUser);

			userService.updateUser(currentUser);

			mView.addObject("currentUser", currentUser);
			mView.setViewName("redirect:/profile/publications");

			return mView;
		}

}
