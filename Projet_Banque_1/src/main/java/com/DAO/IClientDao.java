package com.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Client;


@Repository
public interface IClientDao extends JpaRepository<Client, Integer> {
	
	public Client findById(int id);
	
}
