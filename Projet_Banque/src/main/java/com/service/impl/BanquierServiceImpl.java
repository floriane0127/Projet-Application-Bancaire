package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.IBanquierDao;
import com.entity.Banquier;
import com.service.IBanquierService;


@Service
public class BanquierServiceImpl implements IBanquierService{

	@Autowired
    IBanquierDao bankistDao;
	
	public void BanqierServiceImpl(IBanquierDao bankistDao) {
		this.bankistDao = bankistDao;
	}

	@Override
	public Banquier save(Banquier banque) {
		return bankistDao.save(banque);
	}

	@Override
	public Banquier update(Banquier banque) {
		return bankistDao.save(banque);
	}

	@Override
	public void delete(Banquier banque) {	
		bankistDao.delete(banque);
	}

	@Override
	public Banquier findById(Integer id) {
		return bankistDao.findById(id).orElse(null);
	}

	@Override
	public List<Banquier> findAll() {
		return bankistDao.findAll();
	}
}
