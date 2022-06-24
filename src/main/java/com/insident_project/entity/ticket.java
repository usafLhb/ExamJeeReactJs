package com.insident_project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
 
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class ticket {
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String nomClient;
	    private double prix;
	    @Column(unique=true,nullable = true)
	    private Integer codePayement; 
	    @Temporal(TemporalType.DATE)
	    private Date createDate;
	    @ManyToOne
	    private film movie;
}
