package com.insident_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insident_project.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	Product findByName(String name);
	

}
