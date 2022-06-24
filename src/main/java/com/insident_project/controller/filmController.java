package com.insident_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insident_project.entity.Product;
import com.insident_project.entity.film;
import com.insident_project.services.FilmService;
import com.insident_project.services.ProductService;

@RequestMapping("/film")
@RestController
@CrossOrigin(origins="*")
public class filmController {
	@Autowired
	private FilmService service;
	
	
	@GetMapping("")
	public List<film> get() {
		return service.getFilms();
	}
	
	
	@PostMapping("/{id}")
	public film add(@RequestBody  film movie,@PathVariable int id) {
		return service.save(movie,id);
	}
	
	
	@GetMapping("/{Id}")
	public film get(@PathVariable int Id) {
		return service.findById(Id);
	}
	
	@GetMapping("/titre/{nom}")
	public film get(@PathVariable String nom) {
		return service.findBytitre(nom);
	}
	
	
	@DeleteMapping("/{Id}")
	public String delete(@PathVariable int Id) {
		return service.deleteById(Id);
	}
	
	@PutMapping("/{Id}")
	public film update(@RequestBody film movie,@PathVariable int Id) { 
		return service.update(movie,Id);
	}
	
	
	
	
	
	
}
