package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@DiscriminatorValue("2")

@Entity
public class Client extends UtilisateursCompte {
	

	private String dateNaissance;
	
	private String adresse;
	
	private String mail;
	
	private String nomConseiller;
	
	private int idConseiller;
	
	
	
	

	public Client() {
		super();
	}

	

	public Client(List<com.entity.CptBancaire> cptBancaire, String dateNaissance, String adresse, String mail,
			String nomConseiller, int idConseiller) {
		super();
 		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.mail = mail;
		this.nomConseiller = nomConseiller;
		this.idConseiller = idConseiller;
	}


 


	public String getDateNaissance() {
		return dateNaissance;
	}



	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getNomConseiller() {
		return nomConseiller;
	}



	public void setNomConseiller(String nomConseiller) {
		this.nomConseiller = nomConseiller;
	}



	public int getIdConseiller() {
		return idConseiller;
	}



	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}




	
	

}
