package com.kedut.directory.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kedut.directory.cache.spy.SpyMemcachedCache;
import com.kedut.directory.model.Business;
import com.kedut.directory.model.Product;

@Component
public class KedutCache {
	
	@Autowired
	private SpyMemcachedCache memcached;
	
	public List<Business> getBusiness(String key){
		
		return (List<Business>) memcached.get(key);
	}

	public List<Product> getProduct(String key){
		
		return (List<Product>) memcached.get(key);
	}
	
	public void saveBusinesses(String key, List<Business> businesses){
		memcached.add(key, (Serializable) businesses);
	}

	public void saveProducts(String key, List<Product> products){
		memcached.add(key, (Serializable) products);
	}

	
	public SpyMemcachedCache getMemcached() {
		return memcached;
	}

	public void setMemcached(SpyMemcachedCache memcached) {
		this.memcached = memcached;
	}

	
}
