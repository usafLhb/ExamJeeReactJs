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

import com.insident_project.entity.film;
import com.insident_project.entity.ticket;
import com.insident_project.services.CategorieService;
import com.insident_project.services.TicketService;

@RequestMapping("/ticket")
@RestController
@CrossOrigin(origins="*")
public class ticketController {

	
	@Autowired
	private TicketService service;
	
	
	
	@GetMapping("")
	public List<ticket> get() {
		return service.get();
	}
	
	
	@PostMapping("/{id}")
	public ticket add(@RequestBody  ticket tk,@PathVariable int id) {
		return service.save(tk,id);
	}
	
	
 
	
	
	@DeleteMapping("/{Id}")
	public String delete(@PathVariable int Id) {
		return service.deleteById(Id);
	}
	
 
	
}
