package com.service;

import java.util.List;

import com.entity.Virement;



public interface IVirementService {
	
	public Virement save(Virement vir);
	
	public void delete(Virement vir);
	
	public Virement findById(Integer id);
	
	public List<Virement> findAll();

}
