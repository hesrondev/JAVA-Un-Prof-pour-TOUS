package com.ingesup.labojava.controller;

import java.util.ArrayList;
import java.util.List;

import com.ingesup.labojava.bean.Annonce;
import com.ingesup.labojava.form.Filter;
import com.ingesup.labojava.form.FilterCategory;

public class Utilities {
	
	
	/**
	 * TRIS ET FILTRES
	 */
	
	
	
	// Renvoie la liste d'une catégorie de liste parmi tous les filtres de
	// 'allFilters'

	public static List<Filter> getFiltersByCategory(List<Filter> allFilters, FilterCategory fcat) {

		List<Filter> filters = new ArrayList<Filter>();
		for (Filter f : allFilters) {

			if (f.geteCategory().equals(fcat))
				filters.add(f);
		}
		return filters;
	}


	// Initialise tous les filtres en fonctions des annonces
	// On a aussi besoin de la liste des utilisateurs pour connaitre leurs

	public static List<Filter> createFilters(List<Annonce> annonces) {
		List<Filter> filters = new ArrayList<Filter>();

		System.out.println("//////////////// Creating filters... -- annonces : " + annonces.size());

		for (Annonce ad : annonces) {

			// On parcourt la liste des filtres pour chercher les filtres

			// index des éléments dans la liste filters [-1 = pas trouvé, > -1 =
			// index = présent]
			int iStatus = -1;
			int iLocation = -1;
			int iLevel = -1;
			int iSubject = -1;

			for (int i = 0; i < filters.size(); i++) {

				Filter f = filters.get(i);

				// On compare les valeurs des différents attributs de l'annonce
				// à la valeur du filtre
				// Si on trouve une valeur égale, on l'incrémente sinon on va le
				// créer

				if (ad.getUser().getType().equals(f.getValue())) {
					f.counterPlus();
					System.out.println("--STATUS-- " + ad.getUser().getType() + " -- COUNTER : " + f.getCounter());
					iStatus = i;
				}

				if (ad.getLocation().equals(f.getValue())) {
					f.counterPlus();
					iLocation = i;
					System.out.println("--LOCATION-- " + ad.getLocation() + " -- COUNTER : " + f.getCounter());
				}

				else if (ad.getSubject().equals(f.getValue())) {
					f.counterPlus();
					iSubject = i;
					System.out.println("--SUBJECT-- " + ad.getSubject() + " -- COUNTER : " + f.getCounter());
				}

				else if (ad.getLevel().equals(f.getValue())) {
					f.counterPlus();
					iLevel = i;
					System.out.println("--LEVEL-- " + ad.getLevel() + " -- COUNTER : " + f.getCounter());
				}
			}

			// Si l'index est toujours à -1, on ajoute le filtre
			if (iStatus == -1) {
				filters.add(new Filter(FilterCategory.STATUS, ad.getUser().getType()));
				System.out.println("Adding STATUS FILTER...");
			}

			if (iLocation == -1) {
				filters.add(new Filter(FilterCategory.LOCATION, ad.getLocation()));
				System.out.println("Adding LOCATION FILTER...");
			}

			if (iSubject == -1) {
				filters.add(new Filter(FilterCategory.SUBJECT, ad.getSubject()));
				System.out.println("Adding subject FILTER...");
			}

			if (iLevel == -1) {
				filters.add(new Filter(FilterCategory.LEVEL, ad.getLevel()));
				System.out.println("Adding level FILTER...");
			}
		}

		System.out.println("////////////ALL " + filters.size());

		return filters;
	}
}
