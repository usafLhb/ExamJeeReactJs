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

import com.insident_project.entity.Categorie;
import com.insident_project.entity.film;
import com.insident_project.repository.CategorieRepo;
import com.insident_project.services.CategorieService;
import com.insident_project.services.FilmService;

@RequestMapping("/categorie")
@RestController
@CrossOrigin(origins="*")
public class CategorieController {
	@Autowired
	private CategorieService service;
	
	
	
	
	@GetMapping("")
	public List<Categorie> get() {
		return service.get();
	}
	
	
	@PostMapping("")
	public Categorie add(@RequestBody  Categorie cat) {
		return service.save(cat);
	}
	
	
	@DeleteMapping("/{Id}")
	public String delete(@PathVariable int Id) {
		return service.deleteById(Id);
	}
	
 
	
	
	
	
}
