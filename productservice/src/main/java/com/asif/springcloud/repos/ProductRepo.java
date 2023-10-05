package com.asif.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asif.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	

}
