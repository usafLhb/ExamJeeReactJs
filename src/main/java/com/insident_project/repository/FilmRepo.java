package com.insident_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insident_project.entity.Product;
import com.insident_project.entity.film;

public interface FilmRepo extends JpaRepository<film,Integer> {
	
	film findByTitre(String name);
}
