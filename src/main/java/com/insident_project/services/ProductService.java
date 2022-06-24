package com.insident_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insident_project.entity.Product;
import com.insident_project.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product  saveProduct(Product products) {
		return repository.save(products);
	}
	 
	public List<Product> saveProducts(List<Product> products){
		return repository.saveAll(products);
	}
	
	public Product findById(int id) {
		return repository.findById(id).orElse(null);
	}
	public Product findByName(String Name) {
		return repository.findByName(Name);
	}
	public List<Product> getProducts() {

		return repository.findAll();
	}

	public String deleteById(int id) {
		repository.deleteById(id);
		return "product deleted successfully";
	}
	public  Product updateProduct(Product product,int id) {
		
		System.out.print(product.getId());
	 Product productExisting = repository.findById(id).orElse(null);
		productExisting.setName(product.getName());
		productExisting.setQuantity(product.getQuantity());
		productExisting.setPrice(product.getPrice());
		System.out.println("************");
		return repository.save(productExisting);  
	} 
}
