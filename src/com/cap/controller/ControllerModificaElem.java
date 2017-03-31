package com.cap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cap.dao.AccessoAltriCampi;
import com.cap.dao.AccessoContatti;
import com.cap.formObject.FormModificaElem;


@Controller
public class ControllerModificaElem {
	
	@Autowired private UserSession usSession;
	
	@RequestMapping(value = "/modificaElem", method = RequestMethod.POST)
	public String ModificaElemPost(@ModelAttribute("formModificaElem")FormModificaElem formModificaElem, ModelMap model) 
	{
		if( usSession.getId() == -1)
		{
			return "redirect:/login" ;
		}
		else 
		{
			if(formModificaElem.getNuovoValore() != null && formModificaElem.getNuovoValore() != "")
			{
				if(formModificaElem.getAltroOcontatto().equals("c"))
				{
					AccessoContatti a = new AccessoContatti();
					a.ModifyContatto(formModificaElem.getNuovoValore(), formModificaElem.getNomeAltro() , formModificaElem.getIdContatto());
				}
				if(formModificaElem.getAltroOcontatto().equals("a"))
				{
					AccessoAltriCampi a = new AccessoAltriCampi();
					a.ModifyCampo(formModificaElem.getNuovoValore(),  formModificaElem.getIdContatto());		
				}
				return "redirect:/home";
			}
			else
			{
				model.addAttribute("formModificaElem",  formModificaElem );
				return "modificaElem";
			}
			
		}
	}
	
	@RequestMapping(value = "/modificaElem", method = RequestMethod.GET)
	public String DettagliGet() 
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
