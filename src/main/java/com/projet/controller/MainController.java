package com.projet.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.projet.web.ValidPassword;

@Controller
@SessionAttributes("prenom")
public class MainController {
	
	ValidPassword validPassword = new ValidPassword();
	
	@RequestMapping("/")
	public String pageAccueil() {
		return "accueil";
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String PostMethod(@RequestParam String prenom, @RequestParam String password, Model model) {
		
		if(!validPassword.estValide(prenom, password)) {
			
			model.addAttribute("error_login", "Le prenom ou mot de passe est invalide");
			return "accueil";
			
		}
		
		model.addAttribute("prenom", prenom);
		model.addAttribute("password", password);
		
		return "bienvenue";
	}
}