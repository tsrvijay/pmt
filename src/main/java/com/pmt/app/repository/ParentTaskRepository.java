package com.pmt.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.app.model.ParentTask;



public interface ParentTaskRepository extends JpaRepository<ParentTask, Long>{
	
}
