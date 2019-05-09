package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.ICptBancaireDao;
import com.DAO.IVirementDao;
import com.entity.CptBancaire;
import com.entity.Message;
import com.entity.Virement;
import com.service.IVirementService;




@Service
public class VirementServiceImpl implements IVirementService {

	@Autowired
	IVirementDao virementDao;
	
	@Autowired
	ICptBancaireDao cptbcaireDao;
	
/*	@Autowired
	ICptService cptService;*/
	
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
		System.out.println(virementDao.findAll());
		return virementDao.findAll();
	}
	
	/*public boolean faireVirement(BidgDecimal montant, Compte cptExpediteur, Compte cptRecepteur) {
		if((cptExpediteur.getSolde - montant) >0) {
			this.cptService.credit(cptRecepteur,montant)
			this.cptService.debit(cptExpediteur,montant)
		}
	}*/

	@Override
	public void credit(Virement vir) {
		CptBancaire cpt=cptbcaireDao.findById(vir.getIdRecepteur()); // cpt est le compte à créditer
		double oldsolde = cpt.getSolde();
		double newsolde = oldsolde + vir.getMontant();
		cpt.setSolde(newsolde);		
		
	}

	@Override
	public void debit(Virement vir) {
		CptBancaire cpt=cptbcaireDao.findById(vir.getIdEmetteur()); // cpt est le compte à débiter
		double oldsolde = cpt.getSolde();
		double newsolde = oldsolde - vir.getMontant();
		cpt.setSolde(newsolde);	
		
	}

	@Override
	public List<Virement> findbyIdRecepteur(Integer idRecepteur) {
		return this.virementDao.findByIdRecepteur(idRecepteur);
	}

}
