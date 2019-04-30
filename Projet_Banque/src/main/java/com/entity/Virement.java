package com.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Virements")
public class Virement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String date;
	String idEmetteur;
	String idRecepteur;
	double montant;

	public Virement() {
		super();
	}



	public Virement(int id, String date, String idEmetteur, String idRecepteur, double montant) {
		super();
		this.id = id;
		this.date = date;
		this.idEmetteur = idEmetteur;
		this.idRecepteur = idRecepteur;
		this.montant = montant;
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



	public String getIdEmetteur() {
		return idEmetteur;
	}



	public void setIdEmetteur(String idEmetteur) {
		this.idEmetteur = idEmetteur;
	}



	public String getIdRecepteur() {
		return idRecepteur;
	}



	public void setIdRecepteur(String idRecepteur) {
		this.idRecepteur = idRecepteur;
	}



	public double getMontant() {
		return montant;
	}



	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	
	

}