package com.pmt.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pmt.app.model.Project;


public interface ProjectRepository extends JpaRepository<Project, Long>{
	@Query(value ="update Project set status=?1 where projectId=?1",nativeQuery=true)
	void updateProjectStatus(String status, Long projectId);
}
