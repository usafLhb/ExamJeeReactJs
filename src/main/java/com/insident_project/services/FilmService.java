package com.insident_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insident_project.entity.Categorie;
import com.insident_project.entity.Product;
import com.insident_project.entity.film;
import com.insident_project.repository.CategorieRepo;
import com.insident_project.repository.FilmRepo;
@Service
public class FilmService {
	@Autowired
	private FilmRepo repository;
	
	@Autowired
	private CategorieRepo Catrepository;
	

	public film  save(film movie,int id) {
		Categorie cat=Catrepository.findById(id).orElse(null);
		movie.setCategorie(cat);
		return repository.save(movie);
	}
	 
	 
	
	public film findById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public film findBytitre(String titre) {
		return repository.findByTitre(titre);
	}
	 
	public List<film> getFilms() {
		return repository.findAll();
	}

	public String deleteById(int id) {
		repository.deleteById(id);
		return "film deleted successfully";
	}
	
	public  film update(film movie,int id) {
		 
	film filmExisting = repository.findById(id).orElse(null);
	filmExisting.setTitre(movie.getTitre());
	filmExisting.setDescription(movie.getDescription());
	filmExisting.setDuree(movie.getDuree());
		System.out.println("************");
		return repository.save(filmExisting);  
	} 
}
