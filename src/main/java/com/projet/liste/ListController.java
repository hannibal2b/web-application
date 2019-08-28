package com.projet.liste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projet.web.ValidPassword;

@Controller
public class ListController {
	
	@Autowired
	ListeAFaireService listeAFaireService ;
	
	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public String MalisteDesTaches(Model model) {
		
		model.addAttribute("liste", listeAFaireService.recupererListe("Mes élèves"));
		
		return "liste";
	}
	
	@RequestMapping(value = "/ajout-liste", method = RequestMethod.GET)
	public String MalisteDesTaches() {
		
		return "ajout-liste";
	}
	

}
