package com.cap.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "CONTATTI")

public class Contatto {
	
	@Id @GeneratedValue 
	@Column (name="ID_CONTATTO")	
	private int idContatto;
	
	@Column (name="NOME")
	private String nome;
	
	@Column (name="COGNOME")
	private String cognome;
	
	@Column (name="CELLULARE")
	private String cellulare;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_UTENTE", nullable = false)
	private Utenti utente;	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "contatto")
	private List<AltriDati> altriDati;
	
	// SET e GET di idContatto
	public void setIdContatto(int s)
	{
		idContatto=s;
	}
	
	public int getIdContatto()
	{
		return idContatto;
	}
	
	// SET e GET di nome
	public void setNome(String s)
	{
		nome=s;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	// SET e GET di cognome
	public void setCognome(String s)
	{
		cognome=s;
	}
	
	public String getCognome()
	{
		return cognome;
	}
	
	// SET e GET di cellulare
	public void setCellulare(String s)
	{
		cellulare=s;
	}
	
	public String getCellulare()
	{
		return cellulare;
	}

	public List<AltriDati> getAltriDati() {
		return altriDati;
	}

	public void setAltriDati(List<AltriDati> altriDati) {
		this.altriDati = altriDati;
	}

	public Utenti getUtente() {
		return utente;
	}

	public void setUtente(Utenti utente) {
		this.utente = utente;
	}


	
}