package com.kedut.directory.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedut.directory.exception.NotFoundException;
import com.kedut.directory.model.Address;
import com.kedut.directory.model.Business;
import com.kedut.directory.model.BusinessCategory;
import com.kedut.directory.model.Product;
import com.kedut.directory.model.ProductCategory;
import com.kedut.directory.service.AddressService;
import com.kedut.directory.service.BusinessCategoryService;
import com.kedut.directory.service.BusinessService;
import com.kedut.directory.service.ProductCategoryService;
import com.kedut.directory.service.ProductService;
import com.kedut.jmx.JmxSearchBean;


/**
 * @author ibeani01
 *
 */
@Controller
@Transactional
public class SearchController {
	
	@Autowired
	private BusinessCategoryService businessCatService;
	
	@Autowired
	private ProductCategoryService productCatService;
	
	@Autowired
	private BusinessService businessService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private AddressService addressService;
	@Autowired
	private JmxSearchBean searchBean;
	
	
	/*****************************************************************************
	 * 
	 * Get all the business categories
	 *
	 * @param request, reponse
	 * 
	 * @return List JSON
	 * 
	 * 
	 * 	  
	 * ***************************************************************************/
	
	@Transactional
	@RequestMapping(value = "/businesscats", method = RequestMethod.GET)
	public @ResponseBody List<BusinessCategory> getBusinessCategories(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");
		return businessCatService.getBusinessCategories();
		
	}
	
	/**
	 * @param request, reponse
	 * @return List JSON
	 * 
	 * Get the products Categories for the business category id
	 * 	
	 * 
	 **/
	@Transactional
	@RequestMapping(value = "productcats/{cat}/{id}", method = RequestMethod.GET)
	public @ResponseBody List<ProductCategory> getProductCategories(HttpServletRequest request, HttpServletResponse response,
																@PathVariable String cat, @PathVariable String id ) throws NotFoundException {
		List<ProductCategory> pCats = new ArrayList<ProductCategory>();
		response.addHeader("Access-Control-Allow-Origin","*");
		try {
			pCats =  productCatService.getProductCategories(cat, Long.parseLong(id));
		} catch (NumberFormatException e) {
			response.addIntHeader("id", response.SC_BAD_REQUEST);
			e.printStackTrace();
		}
		 
		return pCats;
	}
	/**
	 * @param request, reponse, id, row, max
	 * @return List JSON
	 * 
	 * Get the businesses for the product category id and with resultset filtered by numbr row start and fetch size	
	 * 
	 **/
	
	@Transactional
	@RequestMapping(value = "businesses/cat/{id}/{row}/{max}", method = RequestMethod.GET)
	public @ResponseBody List<Business> getBusinesses(HttpServletRequest request, HttpServletResponse response,
																@PathVariable String id, @PathVariable String row, 
																@PathVariable String max) throws NotFoundException {
		List<Business> businesses = new ArrayList<Business>();
		response.addHeader("Access-Control-Allow-Origin","*");
					
		try {
			businesses =  businessService.getBusinessByProductId(Long.parseLong(id), Integer.parseInt(row), Integer.parseInt(max));
		} catch (NumberFormatException e) {
			response.addIntHeader("id", response.SC_BAD_REQUEST);
			e.printStackTrace();
		}
		
		return businesses;
		
	}
	
	/*****************************************************************************
	 * 
	 * This methods receives business names with paging and returns the List of
	 * businesses as JSON
	 * 
	 * @author ibeanu
	 * @param request, reponse
	 * 
	 * @return List JSON
	 * 	  
	 * ***************************************************************************/
	
	@Transactional
	@RequestMapping(value = "businesses/{name}/{row}/{max}", method = RequestMethod.GET)
	public @ResponseBody List<Business> getBusinessesByName(HttpServletRequest request, HttpServletResponse response,
																@PathVariable String name, @PathVariable String row, @PathVariable String max) 
																throws NotFoundException {
		List<Business> businesses = new ArrayList<Business>();
		response.addHeader("Access-Control-Allow-Origin","*");
					
		try {
			businesses =  businessService.getBusinessByName(name, Integer.parseInt(row), Integer.parseInt(max));
			searchBean.setName(name);
			searchBean.incrementCounter();
		} catch (NumberFormatException e) {
			response.addIntHeader("id", response.SC_BAD_REQUEST);
			e.printStackTrace();
		}
		
		return businesses;
		
	}
	
	/**
	 * @param request, reponse, name, row, max
	 * @return List JSON
	 * 
	 * Get the products by product names with paging fitering. Returns products in JSON	
	 * 
	 **/
	
	@Transactional
	@RequestMapping(value = "products/{name}/{row}/{max}", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProductsByName(HttpServletRequest request, HttpServletResponse response,
															@PathVariable String name, @PathVariable String row, @PathVariable String max) 
															throws NotFoundException {
		List<Product> products = new ArrayList<Product>();
		response.addHeader("Access-Control-Allow-Origin","*");
					
		try {
			products =  productService.getProductsByName(name, Integer.parseInt(row), Integer.parseInt(max));
		} catch (NumberFormatException e) {
			response.addIntHeader("id", response.SC_BAD_REQUEST);
			e.printStackTrace();
		}
		
		return products;
	}
	
	/**
	 * @param request, reponse, busId
	 * @return List JSON
	 * 
	 * Get product by business ids	
	 * 
	 **/	
	
	@Transactional
	@RequestMapping(value = "products/{busId}", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts(HttpServletRequest request, HttpServletResponse response,
																@PathVariable String busId ) throws NotFoundException {
		List<Product> products = new ArrayList<Product>();
		response.addHeader("Access-Control-Allow-Origin","*");
					
		try {
			products =  productService.getProductsByBusinessId(Long.parseLong(busId));
		} catch (NumberFormatException e) {
			response.addIntHeader("id", response.SC_BAD_REQUEST);
			e.printStackTrace();
		}
		
		return products;
		
	}
	
	/**
	 * @param request, reponse, busId
	 * @return List JSON
	 * 
	 * Get addresses by business id	
	 * 
	 **/	

	@Transactional
	@RequestMapping(value = "addresses/{busId}", method = RequestMethod.GET)
	public @ResponseBody List<Address> getAddresses(HttpServletRequest request, HttpServletResponse response,
																@PathVariable String busId ) throws NotFoundException {
		List<Address> addresses = new ArrayList<Address>();
		response.addHeader("Access-Control-Allow-Origin","*");
					
		try {
			addresses =  addressService.getAddressByBusinessId(Long.parseLong(busId));
		} catch (NumberFormatException e) {
			response.addIntHeader("id", response.SC_BAD_REQUEST);
			e.printStackTrace();
		}
		
		return addresses;
		
	}

}
