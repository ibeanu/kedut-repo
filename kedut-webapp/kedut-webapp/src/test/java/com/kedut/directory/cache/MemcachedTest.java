package com.kedut.directory.cache;

import static org.junit.Assert.assertEquals;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kedut.directory.cache.spy.SpyMemcachedCache;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContextJunit.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class MemcachedTest {

	@Autowired
	private SpyMemcachedCache memcached;
	
	@Test
	public void testAddToCache(){
		
		List value = new ArrayList();
		value.add("Hello");
		String key = "2";
		memcached.add(key , 5000, (Serializable) value);
		
		assertEquals("The value should be " + value, value, memcached.get(key));

	}

}
