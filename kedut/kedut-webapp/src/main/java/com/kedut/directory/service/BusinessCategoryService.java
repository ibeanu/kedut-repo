package com.kedut.directory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kedut.directory.dao.BusinessCategoryDao;
import com.kedut.directory.dao.BusinessCategoryDaoHibernate;
import com.kedut.directory.model.BusinessCategory;

@Component
@Transactional(readOnly = true)
public class BusinessCategoryService {
	
	@Autowired
	private BusinessCategoryDao businessCategoryDao;

	public List<BusinessCategory> getBusinessCategories(){
		return businessCategoryDao.getBusinessCategorys();
	}

	public BusinessCategoryDao getBusinessCategoryDao() {
		return businessCategoryDao;
	}

}
