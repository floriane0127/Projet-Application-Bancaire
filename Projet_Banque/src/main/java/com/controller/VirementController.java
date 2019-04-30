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

import com.entity.Virement;
import com.service.IVirementService;






@RestController
@RequestMapping("/Virement")
@CrossOrigin(origins = "http://localhost:8034")
public class VirementController {
  @Autowired
  IVirementService virementService;

  @GetMapping(value = "/all")
  public List<Virement> findAllVirements() {
   return virementService.findAll();
  }
  
  @PostMapping(value = "/addvirement",
     consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Virement saveNewVirement(@RequestBody Virement vir) {
   return this.virementService.save(vir);

  }

 @DeleteMapping("/{id}")
	public void deleteVirement(@PathVariable int id){
		if(virementService.findById(id)!= null){
			virementService.delete(virementService.findById(id));
		}
	}
 
}

