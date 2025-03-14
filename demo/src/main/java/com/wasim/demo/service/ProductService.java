package com.wasim.demo.service;

import java.util.List;
import java.util.Optional;

import com.wasim.demo.entity.Product;

public interface ProductService {
	
	Product saveProduct(Product product);
	
	List<Product> getAllProducts();
	
	Optional<Product> getProductById(long id);
	
	Product updateProduct(long id, Product product);

	void deleteProduct(Long id);
}
