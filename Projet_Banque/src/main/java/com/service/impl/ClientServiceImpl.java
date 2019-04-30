package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.IClientDao;
import com.entity.Client;
import com.service.IClientService;


@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
    IClientDao customerDao;
	
	public ClientServiceImpl(IClientDao customerDao) {
		this.customerDao = customerDao;
	}

	public Client save(Client client) {
		return customerDao.save(client);
	}

	public Client update(Client client) {
		return customerDao.save(client);
	}

	public void delete(Client client) {	
		customerDao.delete(client);
	}

	public Client findById(Integer id) {
		return customerDao.findById(id).orElse(null);
	}

	public List<Client> findAll() {
		return customerDao.findAll();
	}
    
 
}
