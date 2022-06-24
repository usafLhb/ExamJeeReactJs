package com.insident_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insident_project.entity.Categorie;
import com.insident_project.entity.Product;

public interface CategorieRepo extends JpaRepository<Categorie,Integer> {

}
