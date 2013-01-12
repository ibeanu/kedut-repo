package com.kedut.directory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.kedut.directory.dao.ProductCategoryDao;
import com.kedut.directory.exception.NotFoundException;
import com.kedut.directory.model.Business;
import com.kedut.directory.model.ProductCategory;

@Component
@Transactional
public class ProductCategoryService {
	
	@Autowired
	private ProductCategoryDao productCatDao;
	
	public List<ProductCategory> getProductCategories(String BusinessCategorry, Long id) throws NotFoundException{
		
		return productCatDao.getProductCategories(id);
		
	}
	
	public void saveProductCategories(String name){
		
	}

	public ProductCategoryDao getProductCatDao() {
		return productCatDao;
	}
	
	

}
