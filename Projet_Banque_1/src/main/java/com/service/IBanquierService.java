package com.service;

import java.util.List;

import com.entity.Banquier;

;

public interface IBanquierService {
	
public Banquier save(Banquier banque);
	
	public Banquier update(Banquier banque);
	
	public void delete(Banquier banque);
	
	public Banquier findById(Integer id);
	
	public List<Banquier> findAll();

}
