package com.cap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.model.*;
import com.cap.dao.AccessoUtenti;
import com.cap.formObject.FormAggiungiUtente;



@Controller
public class ControllerAggiungiUtente {
	
	@Autowired private AccessoUtenti accessoUtenti;
	
	@RequestMapping(value = "/registrati", method = RequestMethod.GET)
	public String aggiungiGet(ModelMap model) 
	{

			model.addAttribute("FormAggiungiUtente", new FormAggiungiUtente());
			return "registrati" ;
		
		
	}
	
	
	@RequestMapping(value = "/registrati", method = RequestMethod.POST)
	public String aggiungiPost(@ModelAttribute("FormAggiungiUtente")FormAggiungiUtente formAggiungiUtente, ModelMap model) 
	{
		if (formAggiungiUtente.getUsername() != null && formAggiungiUtente.getPassword() != null  && formAggiungiUtente.getUsername() != "" && formAggiungiUtente.getPassword() != "" )
		{
			Utenti utente = new Utenti();
			utente.setUsername(formAggiungiUtente.getUsername());
			utente.setPassword(formAggiungiUtente.getPassword());
			
			accessoUtenti.AddUtente(utente);
			
			return "redirect:/home";
		}
		else
		{
			return "redirect:/registrati";
		}
	}
	
	
}
