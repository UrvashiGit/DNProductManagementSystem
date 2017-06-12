package com.us.service;

import java.util.List;

import com.us.entity.Product;

public interface IProductService {
	List<Product> save(Product product);
	Product findById(Integer id);
	void delete(int id);
	List<Product> getProductList();
	void updateProduct(Product product);
}
