package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;


@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_cpt",discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue("0")

@Entity
public class UtilisateursCompte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ucpt")
	 private int id;
	
	 private String nom;
	
	 private String prenom;
	
	
	@ManyToMany(mappedBy="MsgsUsersss")
	private List<Message> employers=new ArrayList<Message>();


	public UtilisateursCompte() {
		super();
	}

	public UtilisateursCompte(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		
	}

	
	
	public UtilisateursCompte(int id, String nom, String prenom, String adresse, String dateNaissance, List<Message> employers) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.employers = employers;
	}

	public List<Message> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Message> employers) {
		this.employers = employers;
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
	
	
	

}
