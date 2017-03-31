package com.cap.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	
	private String username;
	private int id;
	
	//COSTRUTTORE
	public UserSession()
	{
		id = -1;
	}
	
	
	//set get username
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	//set get id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
