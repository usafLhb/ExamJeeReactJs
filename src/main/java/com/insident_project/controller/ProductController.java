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
import org.springframework.web.bind.annotation.RestController;

import com.insident_project.entity.Product;
import com.insident_project.services.ProductService;

@RestController
@CrossOrigin(origins="*")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/AddProduct")
	public Product addProduct(@RequestBody  Product product) {
		return service.saveProduct(product);
	}
	
	
	@GetMapping("/GetProduct")
	public List<Product> GetProduct() {
		return service.getProducts();
	}
	
	@GetMapping("/GetProduct/{Id}")
	public Product GetProduct(@PathVariable int Id) {
	 
		return service.findById(Id);
	}
	
	
	@DeleteMapping("/DeleteProduct/{Id}")
	public String DeleteProduct(@PathVariable int Id) {
		return service.deleteById(Id);
	}
	
	@PutMapping("/UpdateProduct/{Id}")
	public Product UpdateProduct(@RequestBody Product product,@PathVariable int Id) {
		//System.out.println("Le tout string est "+product.toString());
		return service.updateProduct(product,Id);
	}
	
	
	
	
}
