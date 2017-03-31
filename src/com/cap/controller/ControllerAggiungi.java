package com.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.dao.AccessoContatti;
import com.cap.formObject.FormLogin;
import com.cap.formObject.FormUtente;
import com.cap.model.Contatto;
import com.cap.model.Utenti;

@Controller
public class ControllerAggiungi {
	
	@Autowired private UserSession usSession;
	@Autowired private AccessoContatti accessoContatti;
	
	@RequestMapping(value = "/aggiungi", method = RequestMethod.GET)
	public String aggiungiGet(ModelMap model) 
	{
		if( usSession.getId() == -1)
		{
			model.addAttribute("formDiLogin", new FormLogin());
			return "login" ;			
		}
		else
		{
			model.addAttribute("formNuovoUtente", new FormUtente());
			return "aggiungi" ;
		}
		
	}
	
	
	@RequestMapping(value = "/aggiungi", method = RequestMethod.POST)
	public String aggiungiPost(@ModelAttribute("formNuovoUtente")FormUtente formUtente, ModelMap model) 
	{
		if( usSession.getId() == -1)
		{
			model.addAttribute("formDiLogin", new FormLogin());
			return "login" ;			
		}
		else
		{
		if (formUtente.getNome() != null && formUtente.getCognome() != null && formUtente.getCellulare() != null && formUtente.getNome() != "" && formUtente.getCognome() != "" && formUtente.getCellulare() != "")
		{
			Contatto contatto = new Contatto();
			contatto.setNome(formUtente.getNome());
			contatto.setCognome(formUtente.getCognome());
			contatto.setCellulare(formUtente.getCellulare());
			Utenti utente = new Utenti();
			utente.setIdUtente(usSession.getId());
			contatto.setUtente(utente);

			accessoContatti.AddContatto(contatto);
			return "redirect:/home";
		}
		else
		{
			return "redirect:/aggiungi";
		}
		}
	}
	
	
}
