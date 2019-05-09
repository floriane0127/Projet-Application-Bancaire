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

import com.entity.Message;
import com.service.IMessageService;




@RestController
@RequestMapping("/msg")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {
  @Autowired
  IMessageService msgService;

  @GetMapping(value = "/all")
  public List<Message> findAllMessages() {
   return msgService.findAll();
  }
  
  @GetMapping(value = "/all/findByIdRecepteur/{id}")
  public List<Message> findByIdRecepteur(@PathVariable int idRecepteur) {
	  if(msgService.findByIdRecepteur(idRecepteur)== null) {
	  		return null;
	  	}else {
   return msgService.findByIdRecepteur(idRecepteur);
  }}
  
  @GetMapping(value = "/findById/{id}")
  public Message findById(@PathVariable int id) {
  	if(msgService.findById(id)== null) {
  		return null;
  	}else {
  		return msgService.findById(id) ;
  	}    }
  
  
  @PostMapping(value = "/addmsg",
     consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Message saveNewMessage(@RequestBody Message msg) {
    System.out.println(msg.getContenu());
   return this.msgService.save(msg);

  }

 @DeleteMapping("/{id}")
 public void deleteMessage(@PathVariable int id) {
   if(msgService.findById(id)!= null) {
	   msgService.delete(msgService.findById(id));
   }
  }
}

