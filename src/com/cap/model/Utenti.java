package com.cap.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "UTENTI")

public class Utenti {
	
	@Id @GeneratedValue 
	@Column (name="ID_UTENTE")
	private int idUtente;
	
	@Column (name="USERNAME")
	private String username;
	
	@Column (name="PSW")
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utente")
	private List<Contatto> contatti;
	
	
	
	
	// SET e GET di username
	public void setUsername(String s) {
		username = s;
	}

	public String getUsername() {
		return username;
	}

	// SET e GET di password
	public void setPassword(String s) {
		password = s;
	}

	public String getPassword() {
		return password;
	}



	public List<Contatto> getContatti() {
		return contatti;
	}

	public void setContatti(List<Contatto> contatti) {
		this.contatti = contatti;
	}


	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

}
