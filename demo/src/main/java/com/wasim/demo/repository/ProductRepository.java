package com.wasim.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wasim.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
