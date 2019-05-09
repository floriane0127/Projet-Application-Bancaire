package com.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Virements")
public class Virement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String date;
	private int idEmetteur;
	private int idRecepteur;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="virCpt" )
	private CptBancaire comptebibi;

	public Virement() {
		super();
	}



	public Virement(int id, String date, int idEmetteur, int idRecepteur, double montant,
			CptBancaire comptebibi) {
		super();
		this.id = id;
		this.date = date;
		this.idEmetteur = idEmetteur;
		this.idRecepteur = idRecepteur;
		this.montant = montant;
		this.comptebibi = comptebibi;
	}



	public Virement(int id, String date, int idEmetteur, int idRecepteur, double montant) {
		super();
		this.id = id;
		this.date = date;
		this.idEmetteur = idEmetteur;
		this.idRecepteur = idRecepteur;
		this.montant = montant;
	}

	


	public CptBancaire getComptebibi() {
		return comptebibi;
	}



	public void setComptebibi(CptBancaire comptebibi) {
		this.comptebibi = comptebibi;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public int getIdEmetteur() {
		return idEmetteur;
	}



	public void setIdEmetteur(int idEmetteur) {
		this.idEmetteur = idEmetteur;
	}



	public int getIdRecepteur() {
		return idRecepteur;
	}



	public void setIdRecepteur(int idRecepteur) {
		this.idRecepteur = idRecepteur;
	}



	public double getMontant() {
		return montant;
	}



	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	
	

}