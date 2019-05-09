package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.ICptBancaireDao;
import com.entity.CptBancaire;
import com.entity.Virement;
import com.service.IVirementService;






@RestController
@RequestMapping("/Virement")
@CrossOrigin(origins = "http://localhost:4200")
public class VirementController {
  @Autowired
  IVirementService virementService;
  
  @Autowired
  CptBancaireController cptctrl;
  
  @Autowired
	ICptBancaireDao cptbcaireDao;

  @GetMapping(value = "/all")
  public List<Virement> findAllVirements() {
   return virementService.findAll();
  }
  
  @GetMapping(value = "/all/findByIdRecepteur/{id}")
  public List<Virement> findByIdRecepteur(@PathVariable int idRecepteur) {
	  if(virementService.findbyIdRecepteur(idRecepteur)== null) {
	  		return null;
	  	}else {
   return virementService.findbyIdRecepteur(idRecepteur);
  }}
  
  @GetMapping(value = "/findById/{id}")
  public Virement findById(@PathVariable int id) {
  	if(virementService.findById(id)== null) {
  		return null;
  	}else {
  		return virementService.findById(id) ;
  	}    }
  
  
  @PostMapping(value = "/addvirement",
		     consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		  public void saveNewVirement(@RequestBody Virement vir) {
		   this.virementService.save(vir);
		   int idR=vir.getIdRecepteur();
		   int idE=vir.getIdEmetteur();
		   
		   CptBancaire useraccR = cptbcaireDao.findById(vir.getIdRecepteur());
		   CptBancaire useraccE = cptbcaireDao.findById(vir.getIdEmetteur());
		  // this.virementService.faireVirement(virement.getMontant(),useraccE, useraccR)
		   cptctrl.updateCompte(useraccR, idR);
		   cptctrl.updateCompte(useraccE, idE);

		  }

 @DeleteMapping("/{id}")
	public void deleteVirement(@PathVariable int id){
		if(virementService.findById(id)!= null){
			virementService.delete(virementService.findById(id));
		}
	}
 
}

