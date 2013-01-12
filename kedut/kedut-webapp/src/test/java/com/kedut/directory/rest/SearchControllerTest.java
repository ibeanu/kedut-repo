package com.kedut.directory.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextJunit.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class SearchControllerTest {
	
	@Autowired
	RestTemplate restTemplate;

	@Test
	public void testGetBusinessCategories() {
		
		 Object result = restTemplate.getForObject("http://localhost:8002/kedut/businesscats", Object.class);

		fail("Not yet implemented");
	}

}
