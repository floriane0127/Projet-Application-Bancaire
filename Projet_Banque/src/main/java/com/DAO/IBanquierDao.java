package com.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Banquier;



@Repository
public interface IBanquierDao extends JpaRepository<Banquier, Integer> {
	
	public Banquier findById(int id);
	

}
