package com.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Compte_Bancaire")
public class CptBancaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	int idUtilisateur;
	String IBAN;
	String BIC;
	double solde;

	public CptBancaire() {
		super();
	}

	

	public CptBancaire(int id, int idUtilisateur, String iBAN, String bIC, double solde) {
		super();
		this.id = id;
		this.idUtilisateur = idUtilisateur;
		IBAN = iBAN;
		BIC = bIC;
		this.solde = solde;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getIdUtilisateur() {
		return idUtilisateur;
	}



	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}



	public String getIBAN() {
		return IBAN;
	}



	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}



	public String getBIC() {
		return BIC;
	}



	public void setBIC(String bIC) {
		BIC = bIC;
	}



	public double getSolde() {
		return solde;
	}



	public void setSolde(double solde) {
		this.solde = solde;
	}



	
	
	
	
	

}