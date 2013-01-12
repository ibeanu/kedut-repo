package com.kedut.directory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kedut.directory.cache.KedutCache;
import com.kedut.directory.dao.ProductDao;
import com.kedut.directory.model.Business;
import com.kedut.directory.model.Product;

@Component
@Transactional
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	@Autowired
	private KedutCache cache;
	
	public List<Product> getProductsByBusinessId(Long id){
		
		return productDao.getProductsByBusinessId(id);
	}
	
	public List<Product> getProductsByName(String name, int rowStart, int maxRows){
		StringBuffer key = new StringBuffer();
		key.append(name + "");
		key.append(rowStart + "");
		key.append(maxRows);
		
		List<Product> products = cache.getProduct(key.toString());
		if(null != products){
			return products;
		}else {
			products = productDao.getProductsByName(name, rowStart, maxRows);
			cache.saveProducts(key.toString(), products);
		}
		return products;
											
	}

}
