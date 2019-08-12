package com.pmt.app.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pmt.app.model.Project;


public interface ProjectRepository extends JpaRepository<Project, Long>{
	@Modifying
	@Transactional
	@Query(value ="update Project set status=?1 where project_Id=?2",nativeQuery=true)
	void updateProjectStatus(String status, Long projectId);
	@Modifying
	@Transactional
	@Query(value ="update Project set no_of_tasks=(select count(task_id) from task where status='OPEN' and project_Id=?1) where project_Id=?1",nativeQuery=true)
	void updateProjectTaskCount(Long projectId);
	
	@Modifying
	@Transactional
	@Query(value ="update Project set completed_tasks=(select count(task_id) from task where status='COMPLETED' and project_Id=?1) where project_Id=?1",nativeQuery=true)
	void updateProjectCompletedTaskCount(Long projectId);
	
}
