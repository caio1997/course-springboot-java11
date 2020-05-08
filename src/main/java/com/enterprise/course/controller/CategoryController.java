package com.enterprise.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.course.entities.Category;
import com.enterprise.course.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = categoryService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
		Optional<Category> category = categoryService.findById(id);
		return ResponseEntity.ok(category);
	}
	
	
	
}
