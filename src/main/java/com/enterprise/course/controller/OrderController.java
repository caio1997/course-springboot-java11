package com.enterprise.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.course.entities.Order;
import com.enterprise.course.services.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = orderService.findAdll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<Optional<Order>> findById(@PathVariable Long id){
		Optional<Order> order = orderService.findById(id);
		return ResponseEntity.ok(order);
	}
	
	
	
}
