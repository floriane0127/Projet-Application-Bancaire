package com.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@DiscriminatorValue("1")

@Entity
public class Banquier extends UtilisateursCompte {

	public Banquier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Banquier(int id, String nom, String prenom, String adresse, String dateNaissance, String motDePasse) {
		super(id, nom, prenom, adresse, dateNaissance, motDePasse);
		// TODO Auto-generated constructor stub
	}
	
	

	
}
