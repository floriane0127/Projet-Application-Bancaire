package com.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Compte_Bancaire")
public class CptBancaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cpt")
	private int id;
	private int idUtilisateur;
	private String IBAN;
	private String BIC;
	private double solde;
	
 
	@ManyToOne
	@JoinColumn(name="CptCli" )
	private Client clio;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="Conseillers" , 
			joinColumns=@JoinColumn(name="compte_id" ,referencedColumnName="id_cpt"),
		    inverseJoinColumns=@JoinColumn(name="banquier_id" ,referencedColumnName="id_ucpt")
		
			)
	List<Banquier> ComptesBanban=new ArrayList<Banquier>();

	public CptBancaire() {
		super();
	}





	public CptBancaire(int id, int idUtilisateur, String iBAN, String bIC, double solde,
			List<com.entity.Virement> virement, Client clio, List<Banquier> comptesBanban) {
		super();
		this.id = id;
		this.idUtilisateur = idUtilisateur;
		IBAN = iBAN;
		BIC = bIC;
		this.solde = solde;
		this.clio = clio;
		ComptesBanban = comptesBanban;
	}




	public Client getClio() {
		return clio;
	}



	public void setClio(Client clio) {
		this.clio = clio;
	}



	public List<Banquier> getComptesBanban() {
		return ComptesBanban;
	}



	public void setComptesBanban(List<Banquier> comptesBanban) {
		ComptesBanban = comptesBanban;
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