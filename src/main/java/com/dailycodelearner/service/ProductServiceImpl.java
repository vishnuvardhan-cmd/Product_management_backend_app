package com.dailycodelearner.service;

import java.sql.SQLException;
import java.util.List;

import com.dailycodelearner.ProductRepository;
import com.dailycodelearner.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
	private ProductRepository productRepository;

	@Override
	public int insert(Product product) throws SQLException, ClassNotFoundException {
		int rows=productRepository.insertProduct(product);
		return rows;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub

		return productRepository.findById(id);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return productRepository.deleteById(id);
	}

}
