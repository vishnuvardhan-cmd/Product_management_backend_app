package com.dailycodelearner.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodelearner.entity.Product;
import com.dailycodelearner.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/product")
	public int insertProduct(@RequestBody Product product) {
		int row = 0;
		try {
			row= productService.insert(product);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	@GetMapping("/product")
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Product findById(@PathVariable int id) {
		return productService.findById(id);
	}
	
	@DeleteMapping("/product/{id}")
	public int deleteById(@PathVariable int id) {
		return productService.deleteById(id);
	}
}
