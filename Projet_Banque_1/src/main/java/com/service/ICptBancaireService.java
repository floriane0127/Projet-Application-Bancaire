package com.service;

import java.util.List;

import com.entity.CptBancaire;



public interface ICptBancaireService {
	
public CptBancaire save(CptBancaire compte);
	
	public CptBancaire update(CptBancaire compte);
	
	public void delete(CptBancaire compte);
	
	public CptBancaire findById(Integer id);
	
	public List<CptBancaire> findAll();

}
