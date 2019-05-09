package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;


@DiscriminatorValue("1")

@Entity
public class Banquier extends UtilisateursCompte {
	
	@ManyToMany(mappedBy="ComptesBanban")
	private List<CptBancaire> employers=new ArrayList<CptBancaire>();

	private String agence;


	public Banquier() {
		super();
		
	}

	public Banquier(List<CptBancaire> employers, String agence) {
		super();
		this.employers = employers;
		this.agence = agence;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	
	

	
}
