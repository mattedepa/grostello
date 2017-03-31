package com.cap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.dao.AccessoContatti;
import com.cap.formObject.IdContatto;
import com.cap.model.Contatto;

@Controller
public class ControllerDettagli {
	
	@Autowired private UserSession usSession;
	@Autowired private AccessoContatti accessoContatti;
	
	@RequestMapping(value = "/dettagli", method = RequestMethod.POST)
	public String dettagliPost(@ModelAttribute("idDelContatto")IdContatto idContatto, ModelMap model) 
	{	
		if( usSession.getId() == -1)
		{
			return "redirect:/login" ;
		}
		else 
		{
			Contatto contatto = accessoContatti.SelectContattoDiUtente(idContatto.getIdContatto());
			model.addAttribute("contatto", contatto);
			
			
			return "dettagli" ;
		}
	}
	
	@RequestMapping(value = "/dettagli", method = RequestMethod.GET)
	public String dettagliGet() 
	{	
		if( usSession.getId() == -1)
		{
			return "redirect:/login" ;
		}
		else 
		{
			return "errore" ;
		}
	}
	
	

}
