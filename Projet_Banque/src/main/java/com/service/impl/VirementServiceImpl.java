package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.IVirementDao;
import com.entity.Virement;
import com.service.IVirementService;




@Service
public class VirementServiceImpl implements IVirementService {

	@Autowired
	IVirementDao virementDao;
	
	public VirementServiceImpl(IVirementDao virementDao) {
		this.virementDao = virementDao;
	}

	public Virement save(Virement vir) {
		return virementDao.save(vir);
	}

	public void delete(Virement vir) {	
		virementDao.delete(vir);
	}

	public Virement findById(Integer id) {
		return virementDao.findById(id).orElse(null);
	}

	public List<Virement> findAll() {
		return virementDao.findAll();
	}

}
