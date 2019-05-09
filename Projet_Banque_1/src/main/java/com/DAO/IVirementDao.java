package com.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Message;
import com.entity.Virement;


@Repository
public interface IVirementDao extends JpaRepository<Virement, Integer> {
	
	public Virement findById(int id);
	public List<Virement> findByIdRecepteur(int idRecepteur);
	
}
