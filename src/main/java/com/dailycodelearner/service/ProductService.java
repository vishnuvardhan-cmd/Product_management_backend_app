package com.dailycodelearner.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dailycodelearner.entity.Product;


public interface ProductService {

	public int insert(Product product) throws SQLException, ClassNotFoundException;
	public List<Product> findAll();
	public Product findById(int id);
	public int deleteById(int id);
}
