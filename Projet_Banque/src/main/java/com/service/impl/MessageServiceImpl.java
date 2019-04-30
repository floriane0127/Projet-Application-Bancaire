package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.IMessageDao;
import com.entity.Message;
import com.service.IMessageService;


@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
    IMessageDao messageDao;
	
	public MessageServiceImpl(IMessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public Message save(Message mail) {
		return messageDao.save(mail);
	}

	public void delete(Message mail) {	
		messageDao.delete(mail);
	}

	public Message findById(Integer id) {
		Optional<Message> message = messageDao.findById(id);
		return (message == null ? null : message.orElse(null));
	}
	
    
	public List<Message> findAll() {
		return messageDao.findAll();
	}
}
