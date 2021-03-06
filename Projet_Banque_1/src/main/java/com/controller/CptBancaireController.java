package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CptBancaire;
import com.entity.Message;
import com.service.ICptBancaireService;




@RestController
@RequestMapping("/Compte_Bancaire")
@CrossOrigin(origins = "http://localhost:4200")
public class CptBancaireController {
  @Autowired
  ICptBancaireService cbService;

  @GetMapping(value = "/all")
  public List<CptBancaire> findAllComptes() {
   return cbService.findAll();
  }
  
  @PostMapping(value = "/addcb",
     consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public CptBancaire saveNewCompte(@RequestBody CptBancaire cb) {
   return this.cbService.save(cb);

  }
  
  @GetMapping(value = "/findById/{id}")
  public CptBancaire findById(@PathVariable int id) {
  	if(cbService.findById(id)== null) {
  		return null;
  	}else {
  		return cbService.findById(id) ;
  	}    }

 @PutMapping("/{id}")
 public CptBancaire updateCompte (@RequestBody CptBancaire useracc, @PathVariable int id){
   if(cbService.findById(id)== null) {
     return null;
   }else {
     return cbService.save(useracc);
   }
  }

 @DeleteMapping("/{id}")
 public void deleteCompte(@PathVariable int id) {
   if(cbService.findById(id)!= null) {
	   cbService.delete(cbService.findById(id));
   }
  }
}

