package com.cap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.dao.AccessoUtenti;
import com.cap.formObject.FormLogin;
import com.cap.model.Utenti;



@Controller
public class ControllerLogin {
	
	@Autowired private UserSession usSession;
	@Autowired private AccessoUtenti accessoUtenti;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(ModelMap model) 
	{
		if( usSession.getId() == -1)
		{
			model.addAttribute("formDiLogin", new FormLogin());
			return "login" ;			
		}
		else
		{
			model.addAttribute("formDiLogin", new FormLogin());
			return "redirect:/home" ;
		}
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute("formDiContatto")FormLogin formLogin, ModelMap model) 
	{

		Utenti utente = accessoUtenti.selectUtendeByUsername(formLogin.getUsername());

		if(utente != null && utente.getPassword().equals(formLogin.getPassword()))
		{
			usSession.setId(utente.getIdUtente());
			usSession.setUsername(utente.getUsername());
			return "redirect:/home";
		}		
		else
		{
			return "redirect:/login";
		
		}
	}

}
