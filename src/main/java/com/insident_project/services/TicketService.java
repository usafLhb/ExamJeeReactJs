package com.insident_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insident_project.entity.Categorie;
import com.insident_project.entity.film;
import com.insident_project.entity.ticket;
import com.insident_project.repository.FilmRepo;
import com.insident_project.repository.TicketRepo;

@Service
public class TicketService {
	@Autowired
	private TicketRepo repository;
	@Autowired
	private FilmRepo FilmRepository;
	
	
	
	
	public ticket  save(ticket tik,int id) {
		
		film movie=FilmRepository.findById(id).orElse(null);
		tik.setMovie((movie));
		return repository.save(tik);
	}
	 
	 
	public List<ticket> get() {
		return repository.findAll();
	}
	
	public ticket findById(int id) {
		return repository.findById(id).orElse(null);
	}
	 
 
	 

	public String deleteById(int id) {
		repository.deleteById(id);
		return "ticket deleted successfully";
	}
}
