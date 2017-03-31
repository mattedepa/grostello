package com.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.model.*;
import com.cap.dao.AccessoContatti;
import com.cap.formObject.FormModificaElem;
import com.cap.formObject.IdContatto;
@Controller
public class ControllerModifica {
	

	@Autowired private UserSession usSession;
	
	@Autowired private AccessoContatti accessoContatti;
	
	@RequestMapping(value = "/modifica", method = RequestMethod.POST)
	public String modificaPost(@ModelAttribute("idDelContatto")IdContatto idContatto, ModelMap model) 
	{	
		if( usSession.getId() == -1)
		{
			return "redirect:/login" ;
		}
		else 
		{
			Contatto contatto = accessoContatti.SelectContattoDiUtente(idContatto.getIdContatto());
			model.addAttribute("contatto", contatto);
			model.addAttribute("formModificaElem", new FormModificaElem() );
			model.addAttribute("idContatto", new IdContatto() );
			
			return "modifica" ;
		}
	}
	
	@RequestMapping(value = "/modifica", method = RequestMethod.GET)
	public String modificaGet() 
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
