package com.wasim.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wasim.demo.entity.Product;
import com.wasim.demo.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	ProductService productService;
	
	
	
	public ProductRestController(ProductService productService) {
		
		this.productService = productService;
	}



	@PostMapping("/save-product")
	public Product saveProduct(@RequestBody Product product) {
		Product saveProduct = productService.saveProduct(product);
		
		return saveProduct;
	}
	
	@PostMapping("save-product-new")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		try {
			Product saveProduct = productService.saveProduct(product);
			return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-all-products")
	public ResponseEntity<List<Product>> listofAllProducts(){
		try {
			List<Product> allProducts = productService.getAllProducts();
			return new ResponseEntity<>(allProducts, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-product-by-id/{id}")
	public ResponseEntity<Product> getProductSingleProduct(@PathVariable("id") Long id) {
		Optional<Product> productById = productService.getProductById(id);
		if(productById.isPresent()) {
			return new ResponseEntity<>(productById.get(), HttpStatus.FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/update-product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product updateProduct = productService.updateProduct(id, product);
		
		return new ResponseEntity<>(updateProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
		
		return ResponseEntity.ok("Deleted Successfully");
	}
	
	

}
