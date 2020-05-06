package com.enterprise.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.course.entities.Order;
import com.enterprise.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAdll(){
		return orderRepository.findAll();
	}
	
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}
	
}
