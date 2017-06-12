package com.us.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.us.dao.IProductDAO;
import com.us.entity.Product;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	IProductDAO productDAO;

	public List<Product> save(Product product) {
		// Save 
		productDAO.saveProduct(product);
		//Return List
		return productDAO.getProductList();
	}

	public Product findById(Integer id) {
		return productDAO.findById(id);
	}

	public void delete(int id) {
		productDAO.delete(id);
	}

	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productDAO.getProductList();
	}

	public void updateProduct(Product product) {
		productDAO.updateProduct(product); 
	}
	
	
	
	
}
