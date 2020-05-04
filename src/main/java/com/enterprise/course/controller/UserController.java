package com.enterprise.course.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.course.entities.User;

@Controller
@RequestMapping("/users")
public class UserController {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L, "Caio", "caio_mcoelho@hotmail.com","(37)99132-5133","cacacaio");
		return ResponseEntity.ok(user);
	}
}
