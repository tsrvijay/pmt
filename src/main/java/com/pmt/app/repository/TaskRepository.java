package com.pmt.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.app.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long>{
	
}