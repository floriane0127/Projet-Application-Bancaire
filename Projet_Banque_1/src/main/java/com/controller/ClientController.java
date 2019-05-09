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

import com.entity.Client;
import com.service.IClientService;




@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
	
  @Autowired
  IClientService cliService;

  @GetMapping(value = "/all")
  public List<Client> findAllClients() {
   return cliService.findAll();
  }
  @PostMapping(value = "/addcli",
     consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Client saveNewClient(@RequestBody Client cli) {
   return this.cliService.save(cli);

  }
  
  @GetMapping(value = "/findById/{id}")
  public Client findById(@PathVariable int id) {
  	if(cliService.findById(id)== null) {
  		return null;
  	}else {
  		return cliService.findById(id) ;
  	}    }

 @PutMapping("/{id}")
 public Client updateClient (@RequestBody Client user, @PathVariable int id){
   if(cliService.findById(id)== null) {
     return null;
   }else {
     return cliService.save(user);
   }
  }

 @DeleteMapping("/{id}")
 public void deleteClient(@PathVariable int id) {
   if(cliService.findById(id)!= null) {
	   cliService.delete(cliService.findById(id));
   }
  }
}

