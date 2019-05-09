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

import com.entity.Banquier;
import com.service.IBanquierService;




@RestController
@RequestMapping("/bankister")
@CrossOrigin(origins = "http://localhost:4200")
public class BanquierController {
  @Autowired
  IBanquierService bankistService;

  @GetMapping(value = "/all")
  public List<Banquier> findAllBanquiers() {
   return bankistService.findAll();
  }
  @PostMapping(value = "/addbankist",
     consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public Banquier saveNewBankier(@RequestBody Banquier banki) {
   return this.bankistService.save(banki);

  }

  @GetMapping(value = "/findById/{id}")
  public Banquier findById(@PathVariable int id) {
  	if(bankistService.findById(id)== null) {
  		return null;
  	}else {
  		return bankistService.findById(id) ;
  	}    }
  
  
 @PutMapping("/{id}")
 public Banquier updateBankist (@RequestBody Banquier user, @PathVariable int id){
   if(bankistService.findById(id)== null) {
     return null;
   }else {
     return bankistService.save(user);
   }
  }

 @DeleteMapping("/{id}")
 public void deleteBankist(@PathVariable int id) {
   if(bankistService.findById(id)!= null) {
	   bankistService.delete(bankistService.findById(id));
   }
  }
}

