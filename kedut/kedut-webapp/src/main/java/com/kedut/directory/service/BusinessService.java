package com.kedut.directory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kedut.directory.cache.KedutCache;
import com.kedut.directory.dao.BusinessDao;
import com.kedut.directory.dao.BusinessDaoHibernate;
import com.kedut.directory.exception.NotFoundException;
import com.kedut.directory.model.Business;

@Component
@Transactional
public class BusinessService {

	@Autowired
	private BusinessDao businessDao;
	@Autowired
	private KedutCache cache;
	
	public List<Business> getBusinessByProductId(Long id, int rowStart, int maxRows) throws NotFoundException{
		
		StringBuffer key = new StringBuffer();
		key.append(id + "");
		key.append(rowStart + "");
		key.append(maxRows);
		
		List<Business> businesses = cache.getBusiness(key.toString());
		if(null != businesses){
			return businesses;
		}else {

			businesses = businessDao.getBusinessesByProductCat(id, rowStart, maxRows);
			cache.saveBusinesses(key.toString(), businesses);
		}
		
		return businesses; 
		
	}
	
	public List<Business> getBusinessByName(String name, int rowStart, int maxRows) throws NotFoundException{
		
		StringBuffer key = new StringBuffer();
		key.append(name + "");
		key.append(rowStart + "");
		key.append(maxRows);
		
		List<Business> businesses = cache.getBusiness(key.toString());
		if(null != businesses){
			return businesses;
		}else {
			businesses = businessDao.getBusinessByName(name, rowStart, maxRows);
			cache.saveBusinesses(key.toString(), businesses);
		}
		return businesses;
		
	}


	public void saveBusness(Business business){
		businessDao.saveBusiness(business);
		
	}
	
}
