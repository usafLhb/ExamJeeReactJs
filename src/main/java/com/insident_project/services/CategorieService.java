package com.insident_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insident_project.entity.Categorie;
import com.insident_project.entity.film;
import com.insident_project.repository.CategorieRepo;
import com.insident_project.repository.ProductRepository;

@Service
public class CategorieService {
	@Autowired
	private CategorieRepo repository;
	
	
	
	public Categorie  save(Categorie cat) {
		return repository.save(cat);
	}
	 
	 
	
	public Categorie findById(int id) {
		return repository.findById(id).orElse(null);
	}
	 
	public List<Categorie> get() {
		return repository.findAll();
	}

	public String deleteById(int id) {
		repository.deleteById(id);
		return "Categorie deleted successfully";
	}
	 
	
	
}
