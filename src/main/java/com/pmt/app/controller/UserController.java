package com.pmt.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.pmt.app.controller.service.UserService;
import com.pmt.app.model.User;
@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
    private UserService service;
	
	@GetMapping("/User/findByFirstName/{firstName}")
	public List<User> findByFirstName(@PathVariable String firstName){
		List<User> list = null;
		try {
			logger.info("Calling User service : ");
			list = service.findByFirstName(firstName);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
		return list;
	}
	@GetMapping("/User/findAll/{sortby}")
	public List<User> findAll(@PathVariable String sortby){
		List<User> list = null;
		try {
			logger.info("Calling User service : ");
			list = service.findAll(sortby);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
		return list;
	}
	@GetMapping("/User/search/{searchString}")
	public List<User> searchUser(@PathVariable String searchString){
		List<User> list = null;
		try {
			logger.info("Calling User service : ");
			list = service.search(searchString);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
		return list;
	}
	@PostMapping("/User/save")
	public User save(@RequestBody User user){
		
		try {
			logger.info("Calling User service : ");
			user = service.save(user);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
		return user;
	}
	
	@PostMapping("/User/delete")
	public void delete(@RequestBody User user){
		
		try {
			logger.info("Calling User service : ");
			service.delete(user);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
	}
	
}
