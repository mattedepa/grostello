package com.cap.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.model.*;
import com.cap.dao.AccessoContatti;
import com.cap.formObject.IdContatto;



@Controller
public class ControllerHome {
	
	@Autowired private UserSession usSession;
	@Autowired private AccessoContatti accessoContatti;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeGet(ModelMap model) 
	{	
		if( usSession.getId() == -1)
		{
			return "redirect:/login" ;
		}
		else 
		{
			List<Contatto> rubrica = accessoContatti.SelectAllContattiDiUtente(usSession.getId());

			model.addAttribute("idDelContatto", new IdContatto());
			model.addAttribute("username", usSession.getUsername());
			model.addAttribute("rubrica", rubrica);

			return "home" ;
		}
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String homePost() 
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
