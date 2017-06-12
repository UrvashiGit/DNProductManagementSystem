package com.us.dao;

import java.util.List;

import com.us.entity.Product;

public interface IProductDAO {
	void saveProduct(Product product);
	List<Product> getProductList();
	Product findById(Integer id);
	void delete(int id);
	void updateProduct(Product product);
}
