package com.us.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.us.entity.Product;

@Repository
public class ProductDaoImpl extends TatvaSoftDAOImpl<Product, Integer> implements IProductDAO{

	public ProductDaoImpl() {
		super(Product.class);
	}

	public void saveProduct(Product product) {
		try {
			save(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		List<Product> products = null;
		try {
			products = findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return find(id);
	}

	public void delete(int id) {
		delete(id);
	}

	public void updateProduct(Product product) {
		persist(product);
		
	}

}
