package com.enterprise.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.enterprise.course.entities.User;
import com.enterprise.course.repositories.UserRepository;
import com.enterprise.course.services.exceptions.DatabaseException;
import com.enterprise.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
	
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	public User update(Long id, User user) {
		try {
			User user1 = userRepository.getOne(id);
			user1.setName(user.getName());
			user1.setEmail(user.getEmail());
			user1.setPhone(user.getPhone());
			return userRepository.save(user1);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
}
