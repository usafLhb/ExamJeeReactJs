package com.insident_project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class film {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String titre;
	    private String description; 
	    private Double duree; 
	    private Double prix; 
	  
	    @ManyToOne
	    private Categorie categorie;

}
