package com.services;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.DAO.IMessageDao;
import com.entity.Message;
import com.service.impl.MessageServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceImplTest {
	
	private MessageServiceImpl messageService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImplTest.class);

	@Mock
	private IMessageDao messageDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		messageService = new MessageServiceImpl(messageDao);
	}

	@Test
	public void should_store_when_save_is_called() {
		LOGGER.info("--------------- Executing should_store_when_save_is_called test Of MessageServiceImplTest ---------------");
		Message myMess = new Message();
		messageService.save(myMess);
		Mockito.verify(messageDao).save(myMess);
	}
	
	@Test
	public void should_delete_when_delete_is_called() {
		LOGGER.info("--------------- Executing should_delete_when_delete_is_called test Of MessageServiceImplTest ---------------");
		Message myMess = new Message();
		messageService.delete(myMess);
		Mockito.verify(messageDao).delete(myMess);
	}
	
	@Test
	public void should_search_by_id_when_findById_is_called() {
		LOGGER.info("--------------- Executing should_search_by_id_when_findById_is_called test Of MessageServiceImplTest ---------------");
		Integer id = new Integer(1);
		messageService.findById(id);
		Mockito.verify(messageDao).findById(id);
	}
	
	@Test
	public void should_search_all_when_findAll_is_called() {
		LOGGER.info("--------------- Executing should_search_all_when_findAll_is_called test Of MessageServiceImplTest ---------------");
		messageService.findAll();
		Mockito.verify(messageDao).findAll();
	}

}
