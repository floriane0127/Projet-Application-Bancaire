package com.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_cpt",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("0")

@Entity
public class UtilisateursCompte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String nom;
	
	String prenom;
	
	String adresse;
	
	String DateNaissance;
	
	String MotDePasse;

	public UtilisateursCompte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UtilisateursCompte(int id, String nom, String prenom, String adresse, String dateNaissance,
			String motDePasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		DateNaissance = dateNaissance;
		MotDePasse = motDePasse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDateNaissance() {
		return DateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		DateNaissance = dateNaissance;
	}

	public String getMotDePasse() {
		return MotDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
	}
	
	
	

}
