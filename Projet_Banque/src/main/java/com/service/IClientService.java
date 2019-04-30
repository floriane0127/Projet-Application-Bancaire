package com.service;

import java.util.List;

import com.entity.Client;


public interface IClientService {
	
public Client save(Client client);
	
	public Client update(Client client);
	
	public void delete(Client client);
	
	public Client findById(Integer id);
	
	public List<Client> findAll();

}
