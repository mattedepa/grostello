package com.cap.model;

import javax.persistence.*;

@Entity
@Table (name = "ALTRI_CAMPI")

public class AltriDati {

	@Id @GeneratedValue 
	@Column (name="ID_ALTRO_CAMPO")	
	private int idAltriCampi;
	
	@Column (name="NOME_CAMPO")	
	private String nome_campo;
	
	@Column (name="VALORE_CAMPO")	
	private String valore_campo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CONTATTO", nullable = false)
	private Contatto contatto;
	
	// SET e GET di idAltriCampi
	public void setIdAltriCampi(int s)
	{
		idAltriCampi=s;
	}
	
	public int getIdAltriCampi()
	{
		return idAltriCampi;
	}
	
	
	
	// SET e GET di nome_campo
	public void setNome_campo(String s)
	{
		nome_campo=s;
	}
	
	public String getNome_campo()
	{
		return nome_campo;
	}
	
	// SET e GET di alore_campo
	public void setValore_campo(String s)
	{
		valore_campo=s;
	}
	
	public String getValore_campo()
	{
		return valore_campo;
	}

	public Contatto getContatto() {
		return contatto;
	}

	public void setContatto(Contatto Contatto) {
		this.contatto = Contatto;
	}

}
