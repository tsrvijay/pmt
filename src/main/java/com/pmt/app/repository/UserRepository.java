package com.pmt.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pmt.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByFirstName(String firstName);
	@Query(value ="Select * from User c where c.first_name like %?1% or c.last_name like %?1% or c.employee_Id like %?1% ",nativeQuery=true)
	List<User> findBySearchString(String string);
}
