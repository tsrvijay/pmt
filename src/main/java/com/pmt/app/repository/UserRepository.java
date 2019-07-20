package com.pmt.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByFirstName(String firstName);
}
