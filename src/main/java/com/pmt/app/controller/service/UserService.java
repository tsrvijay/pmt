package com.pmt.app.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.app.model.User;
import com.pmt.app.repository.UserRepository;
 @Service
public class UserService {
	
	@Autowired
    private UserRepository repository;
	
	public List<User> findByFirstName(String firstName){
		return repository.findByFirstName(firstName);
		
	}

}
