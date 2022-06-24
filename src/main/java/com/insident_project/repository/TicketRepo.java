package com.insident_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insident_project.entity.Product;
import com.insident_project.entity.ticket;

public interface TicketRepo  extends JpaRepository<ticket,Integer>{

}
