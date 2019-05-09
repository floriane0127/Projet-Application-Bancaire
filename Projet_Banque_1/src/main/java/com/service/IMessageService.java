package com.service;

import java.util.List;

import com.entity.Message;



public interface IMessageService {
	
	public Message save(Message mail);
	
	public void delete(Message mail);
	
	public Message findById(Integer id);
	
	public List<Message> findAll();
	
	public List<Message> findByIdRecepteur(Integer idRecepteur);

}
