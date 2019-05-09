package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.ICptBancaireDao;
import com.entity.CptBancaire;
import com.service.ICptBancaireService;



@Service
public class CptBancaireServiceImpl implements ICptBancaireService {

	@Autowired
    ICptBancaireDao compteDao;
	
	public CptBancaireServiceImpl(ICptBancaireDao compteDao) {
		this.compteDao = compteDao;
	}

	public CptBancaire save(CptBancaire compte) {
		return compteDao.save(compte);
	}

	public CptBancaire update(CptBancaire compte) {
		return compteDao.save(compte);
	}

	public void delete(CptBancaire compte) {	
		compteDao.delete(compte);
	}

	public CptBancaire findById(Integer id) {
		return compteDao.findById(id).orElse(null);
	}

	public List<CptBancaire> findAll() {
		return compteDao.findAll();
	}
}
