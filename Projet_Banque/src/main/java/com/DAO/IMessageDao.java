package com.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Message;


@Repository
public interface IMessageDao extends JpaRepository<Message, Integer> {
	
	
}
