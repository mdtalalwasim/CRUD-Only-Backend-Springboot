package com.wasim.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wasim.demo.entity.Product;
import com.wasim.demo.repository.ProductRepository;
import com.wasim.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	//@Autowired
	//ProductRepository productRepository;
	
	private ProductRepository productRepository;
	
	
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}



	@Override
	public Product saveProduct(Product product) {
		product.setCreatedAt(new Date());
		return productRepository.save(product);
		
	}



	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}



	@Override
	public Optional<Product> getProductById(long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}



	@Override
	public Product updateProduct(long id, Product product) {
		Optional<Product> dbProduct = productRepository.findById(id);
		if(dbProduct.isPresent()) {
			dbProduct.get().setName(product.getName());
			dbProduct.get().setPrice(product.getPrice());
			dbProduct.get().setQuantity(product.getQuantity());
			
			return productRepository.save(dbProduct.get());
		}
		return null;
	}



	@Override
	public void deleteProduct(Long id) {
		 productRepository.deleteById(id);
	}



	

}
