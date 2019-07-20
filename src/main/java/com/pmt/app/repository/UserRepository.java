package com.pmt.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pmt.app.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findByFirstName(String firstName);
}
