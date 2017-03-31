package com.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.dao.AccessoAltriCampi;
import com.cap.formObject.IdContatto;


@Controller
public class ControllerAggiungiCampo {
	
@Autowired private UserSession usSession;
@Autowired private AccessoAltriCampi accessoAltriCampi;
	
	@RequestMapping(value = "/aggiungiCampo", method = RequestMethod.POST)
	public String aggiungiCampoPost(@ModelAttribute("idDelContatto")IdContatto idContatto, ModelMap model) 
	{	
		if( usSession.getId() == -1)
		{
			return "redirect:/login" ;
		}
		else 
		{
			if(idContatto.getNuovoValore() != null && idContatto.getNuovoValore() != "" && idContatto.getNuovoNome() != null && idContatto.getNuovoNome() != "")
			{					
				accessoAltriCampi.AddUnCampo(idContatto.getNuovoNome() , idContatto.getNuovoValore() , idContatto.getIdContatto());
			
				return "redirect:/home";
			}
			else
			{
				model.addAttribute("idDelContatto",  idContatto );
				return "aggiungiCampo";
			}
			
		}
	}
	
	@RequestMapping(value = "/aggiungiCampo", method = RequestMethod.GET)
	public String aggiungiCampoGet() 
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
