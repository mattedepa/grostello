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
public class ControllerEliminaCampo {
	
@Autowired private UserSession usSession;
@Autowired private AccessoAltriCampi accessoAltriCampi;
	
	@RequestMapping(value = "/eliminaCampo", method = RequestMethod.POST)
	public String eliminaPost(@ModelAttribute("idDelContatto")IdContatto idContatto, ModelMap model) 
	{
		if( usSession.getId() == -1)
		{
			return "redirect:/login" ;
		}
		else
		{
		if(idContatto.getIdContatto() != -1 )
		{
			accessoAltriCampi.DeleteUnCampo(idContatto.getIdContatto());
			return "elimina";
		}
		}
		
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/eliminaCampo", method = RequestMethod.GET)
	public String eliminaGet() 
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

	
	


