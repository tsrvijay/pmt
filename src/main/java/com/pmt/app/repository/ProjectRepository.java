package com.pmt.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.app.model.Project;


public interface ProjectRepository extends JpaRepository<Project, Long>{
	
}
