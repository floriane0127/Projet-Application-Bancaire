package com.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Message;
import com.entity.Virement;


@Repository
public interface IMessageDao extends JpaRepository<Message, Integer> {
	
	public List<Message> findByIdRecepteur(int idRecepteur);
	
	
}
