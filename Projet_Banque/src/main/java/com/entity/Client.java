package com.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("2")

@Entity
public class Client extends UtilisateursCompte {
	
	
	
	String nomConseiller;
	
	int idConseiller;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int id, String nom, String prenom, String adresse, String dateNaissance, String motDePasse,
			String nomConseiller, int idConseiller) {
		super(id, nom, prenom, adresse, dateNaissance, motDePasse);
		this.nomConseiller = nomConseiller;
		this.idConseiller = idConseiller;
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
