package com.enterprise.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.course.entities.Product;
import com.enterprise.course.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = productService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<Optional<Product>> findById(@PathVariable Long id){
		Optional<Product> product = productService.findById(id);
		return ResponseEntity.ok(product);
	}
	
}
