package com.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
		Message addedMessage = messageDao.save(new Message(10, 0125, 032, "11.12.18", "je n'arrive pas à consulter mes comptes", null));
		LOGGER.info("---------------Message saved--------------");
		LOGGER.info("-------------------Searching for Message-----------");
		Message foundMessage = messageDao.findById(new Integer(addedMessage.getId())).orElse(null);
		LOGGER.info("------------------Message found----------");
		LOGGER.info("----------Verifying Message------------");
		assertNotNull(foundMessage);
		assertEquals(addedMessage.getId(), foundMessage.getId());
		LOGGER.info("-------------Message verified-----------");
	}
	
	
	public void givenEntityRepository_whenUpdating() {
		LOGGER.info("-----------Testing givenEntityRepository_whenUpdating method--------");
		Message addedMessage = messageDao.save(new Message(12, 0125, 0325, "11.05.19", "j ai perdu mon mot de passe", null));
		LOGGER.info("-----------Message saved-----------");
		Message modifMessage = messageDao.save(new Message(12, 0, 0, "15.05.19", "j ai perdu mon identifiant", null));
		assertNotNull(modifMessage);
		assertNotEquals(addedMessage.getId(), modifMessage.getId());
		
	}
	@Test
	public void givenEntityRepository_whenDeleting() {
		LOGGER.info("-----------Testing givenEntityRepository_whenDeleting method--------");
		Message addedMessage = messageDao.save(new Message(13, 0325, 0125, "25.05.19", "Voici votre identifiant : 0125", null));
		@SuppressWarnings("unused")
		Message foundMessage = messageDao.findById(new Integer(addedMessage.getId())).orElse(null);
		
		messageDao.delete(addedMessage);
		Message foundMessage1 = messageDao.findById(new Integer(addedMessage.getId())).orElse(null);
		assertNull(foundMessage1);
	}
	
	public void givenEntityRepository_whenRetrievingAll() {
		LOGGER.info("-----------Testing givenEntityRepository_whenDeleting method--------");
		Message addedMessage1 = messageDao.save(new Message(14, 0125, 0325, "26.05.19", "Ou puis-je imprimer un RIB?", null));
		Message addedMessage2 = messageDao.save(new Message(15, 0015, 0325, "27.05.19", "J'aimerai ouvrir un nouveau compte", null));
		Message addedMessage3 = messageDao.save(new Message(16, 0177, 0325, "28.05.19", "J ai perdu ma carte bancaire", null));
		assertNotNull(addedMessage1);
		assertNotNull(addedMessage2);
		assertNotNull(addedMessage3);
		assertNotNull(messageDao.findAll());
		
	}
	
	public void givenEntityRepository_whenRetrievingOneById() {
		Message addedMessage2 = messageDao.save(new Message(15, 0015, 0325, "30.05.19", "J'aimerai ouvrir un nouveau compte", null));
		Message foundMessage = messageDao.findById(new Integer(addedMessage2.getId())).orElse(null);
		assertEquals(addedMessage2.getId(), foundMessage.getId());
		
	}
	

}