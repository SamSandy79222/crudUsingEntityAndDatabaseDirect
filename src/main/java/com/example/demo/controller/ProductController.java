package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/save")
	public Product createProduct(@RequestBody Product product) {
		Product saveProduct = productRepository.save(product);
		return saveProduct;
	}
	
	@GetMapping("/getproduct/{id}")
	public Product getById(@PathVariable long id) {
		Product product=productRepository.findById(id).get();
		return product;
	}
	
	@GetMapping("/getall")
	public List<Product> getAllProduct(){
		List<Product> product = productRepository.findAll();
		return product;
	}
	
	@PutMapping("/update/{id}")
	public String updateProduct(@PathVariable long id,@RequestBody Product product) {
		
		product.setId(id);
		productRepository.save(product);
		return "succesfully update product with id "+id;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		productRepository.deleteById(id);
		return "product deleted succesfully";
	}
	
	
}
