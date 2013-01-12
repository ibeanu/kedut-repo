package com.kedut.directory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kedut.directory.cache.KedutCache;
import com.kedut.directory.dao.BusinessDao;
import com.kedut.directory.dao.ProductCategoryDao;
import com.kedut.directory.exception.NotFoundException;
import com.kedut.directory.model.Business;

@Component
public class SearchService {
	@Autowired
	ProductCategoryDao productCategoryDao;
	@Autowired
	BusinessDao businessDao;
	
	@Autowired
	private KedutCache cache;

	
	public List<Business> getBusinesses(Long id) throws NotFoundException {
		
		return null; //productCategoryDao.getBusinesses(id);
		
	}

	public List<Business> getBusinessesByProductCat(Long id, int rowStart, int maxRows) throws NotFoundException {
		List<Business> businesses = cache.getBusiness(Long.toString(id));
		if(null != businesses){
			return businesses;
		}else {

			businesses = businessDao.getBusinessesByProductCat(id, rowStart, maxRows);
			cache.saveBusinesses(Long.toString(id), businesses);
		}
		
		return businesses; 
	}
	
	public List<Business> getBusinessByName(String name, int rowStart, int maxRows) throws NotFoundException{
		List<Business> businesses = cache.getBusiness(name);
		if(null != businesses){
			return businesses;
		}else {
			businesses = businessDao.getBusinessByName(name, rowStart, maxRows);
			cache.saveBusinesses(name, businesses);
		}
		return businesses;		
	}

	public ProductCategoryDao getProductCategoryDao() {
		return productCategoryDao;
	}
	
	public BusinessDao getBusinessDao() {
		return businessDao;
	}
	
	
}
