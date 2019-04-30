package com.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.entity.Message;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDaoTest {
	
	@Autowired
    private IMessageDao messageDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageDaoTest.class);
	
	
	public void givenEntityRepository_whenSaving() {
		LOGGER.info("-----------Testing givenEntityRepository_whenSaving method--------");
		Message addedMessage = messageDao.save(new Message(10, 0125, 032, "je n'arrive pas à consulter mes comptes"));
		LOGGER.info("---------------Message saved--------------");
		LOGGER.info("-------------------Searching for Message-----------");
		Message foundMessage = messageDao.findById(new Integer(addedMessage.getId())).orElse(null);
		LOGGER.info("------------------Message found----------");
		LOGGER.info("----------Verifying Message------------");
		assertNotNull(foundMessage);
		assertEquals(addedMessage.getIdEmetteur(), foundMessage.getIdEmetteur());
		LOGGER.info("-------------Message verified-----------");
	}
	
	
	public void givenEntityRepository_whenUpdating() {
		LOGGER.info("-----------Testing givenEntityRepository_whenUpdating method--------");
		Message addedMessage = messageDao.save(new Message(12, 0125, 0325, "j ai perdu mon mot de passe"));
		LOGGER.info("-----------Message saved-----------");
		Message modifMessage = messageDao.save(new Message(12, 0, 0, "j ai perdu mon identifiant"));
		assertNotNull(modifMessage);
		assertNotEquals(addedMessage.getIdEmetteur(), modifMessage.getIdEmetteur());
		
	}
	@Test
	public void givenEntityRepository_whenDeleting() {
		LOGGER.info("-----------Testing givenEntityRepository_whenDeleting method--------");
		Message addedMessage = messageDao.save(new Message(13, 0325, 0125, "Voici votre identifiant : 0125"));
		Message foundMessage = messageDao.findById(new Integer(addedMessage.getId())).orElse(null);
		
		messageDao.delete(addedMessage);
		Message foundMessage1 = messageDao.findById(new Integer(addedMessage.getId())).orElse(null);
		assertNull(foundMessage1);
	}
	
	public void givenEntityRepository_whenRetrievingAll() {
		LOGGER.info("-----------Testing givenEntityRepository_whenDeleting method--------");
		Message addedMessage1 = messageDao.save(new Message(14, 0125, 0325, "Ou puis-je imprimer un RIB?"));
		Message addedMessage2 = messageDao.save(new Message(15, 0015, 0325, "J'aimerai ouvrir un nouveau compte"));
		Message addedMessage3 = messageDao.save(new Message(16, 0177, 0325, "J ai perdu ma carte bancaire"));
		assertNotNull(addedMessage1);
		assertNotNull(addedMessage2);
		assertNotNull(addedMessage3);
		assertNotNull(messageDao.findAll());
		
	}
	
	public void givenEntityRepository_whenRetrievingOneById() {
		Message addedMessage2 = messageDao.save(new Message(15, 0015, 0325, "J'aimerai ouvrir un nouveau compte"));
		Message foundMessage = messageDao.findById(new Integer(addedMessage2.getId())).orElse(null);
		assertEquals(addedMessage2.getIdEmetteur(), foundMessage.getIdEmetteur());
		
	}
	

}