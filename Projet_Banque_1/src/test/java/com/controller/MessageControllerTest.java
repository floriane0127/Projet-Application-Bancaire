package com.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.DAO.MessageDaoTest;
import com.entity.Message;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.IMessageService;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MessageControllerTest {

	@Autowired
    private IMessageService messageService;
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageDaoTest.class);
    
  
    @Autowired
    WebApplicationContext webApplicationContext;

protected MockMvc mvc;

@Before
public final void setUp() {
	mvc  = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	MockitoAnnotations.initMocks(this);
}
protected String uri;

public MessageControllerTest() {
	this.uri = "/msg";

}

protected final String mapToJson(Object obj) throws JsonProcessingException {
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(obj);
	}

protected final <T> T mapFromJson(String json, Class<T> clazz)
throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.readValue(json, clazz);
	
}

@Test 
public void getAllEntityList() {
	MvcResult mvcResult;
	try {
		LOGGER.info("--------------Testing getAllEntity Method---------------");
		LOGGER.info("--------------Constructing Message---------------");
		LOGGER.info("--------------Saving Message---------------");
		messageService.save(new Message(2, 00126, 1259, "11.12.18", "Bonjour cher conseiller", null));
		LOGGER.info("--------------Mocking Context WebService---------------");
		mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri + "/all").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		LOGGER.info("--------------Getting HTTP Status---------------");
		int status = mvcResult.getResponse().getStatus();
		LOGGER.info("--------------Verifying HTTP Status---------------");
		assertEquals(200, status);
		LOGGER.info("--------------Getting HTTP Response---------------");
		String content = mvcResult.getResponse().getContentAsString();
		LOGGER.info("--------------Deserializing JSON Response---------------");
		Message[]messageList = this.mapFromJson(content, Message[].class);
		assertTrue(messageList.length > 0);
	}catch (Exception e) {
		e.printStackTrace();
	}
}

@Test 
public void createEntity() {
	MvcResult mvcResult;
	try {
		LOGGER.info("--------------Testing createEntity Method---------------");
		LOGGER.info("--------------Constructing Message---------------");
		Message message = new Message(3, 1259, 00126, "05.01.19", "Bonjour cher client", null);
		

		LOGGER.info("--------------Serializing Message Object---------------");
		String inputJson = this.mapToJson(message);
		LOGGER.info("--------------Mocking Context WebService and invoking the webService---------------");
		mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri + "/addmsg").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		LOGGER.info("--------------Getting HTTP Status---------------");
		int status = mvcResult.getResponse().getStatus();
		LOGGER.info("--------------Verifying HTTP Status---------------");
		assertEquals(200, status);
		LOGGER.info("--------------Searching for Message---------------");
		Message messageFound = messageService.findById(new Integer(50));
		LOGGER.info("--------------Verifying Message---------------");
		assertNotNull(messageFound);
		assertEquals(messageFound.getIdEmetteur(), message.getIdEmetteur());
		
	}catch (Exception e) {
		e.printStackTrace();
	}
		}

			
			@Test 
			public void deleteEntity() {
				MvcResult mvcResult;

				LOGGER.info("--------------Testing deleteEntity Method---------------");
		
				try {
					
					LOGGER.info("--------------Constructing Message---------------");
					LOGGER.info("--------------Saving Message---------------");
					messageService.save(new Message(2, 00126, 1259, "07.01.19", "Bonjour cher conseiller", null));
					LOGGER.info("--------------Mocking Context WebService and invoking the webService---------------");
					mvcResult=mvc.perform(MockMvcRequestBuilders.delete(uri + "/2")).andReturn();
					LOGGER.info("--------------Getting HTTP Status---------------");
					int status = mvcResult.getResponse().getStatus();
					LOGGER.info("--------------Verifying HTTP Status---------------");
					assertEquals(200, status);
					LOGGER.info("--------------Searching for Message---------------");
					Message messageFound = messageService.findById(new Integer(2));
					LOGGER.info("--------------Verifying Message---------------");
					assertEquals(messageFound, null);
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}

}
