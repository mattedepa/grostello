package com.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.cap.formObject.FormLogin;


@Controller
public class ControllerLogout {
	
	@Autowired private UserSession usSession;
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGet(ModelMap model) 
	{
		if( usSession.getId() == -1)
		{
			model.addAttribute("formDiLogin", new FormLogin());
			return "login" ;			
		}
		else
		{
		usSession.setId(-1);
		usSession.setUsername("!");
		return "redirect:/login" ;	
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logoutPost(ModelMap model) 
	{
		if( usSession.getId() == -1)
		{
			model.addAttribute("formDiLogin", new FormLogin());
			return "login" ;			
		}
		else
		{
		usSession.setId(-1);
		usSession.setUsername("!");
		return "redirect:/login" ;
		}
	}

}
