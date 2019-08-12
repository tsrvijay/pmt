package com.pmt.app.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pmt.app.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long>{
	//update Project set status=?1 where project_Id=?2
	
	@Query(value ="Select pt from Task pt where pt.project.projectId=?1",nativeQuery=false)
	List<Task> findByProjectId(Long projectId);
	@Modifying
	@Transactional
	@Query(value ="update Task set status=?1 where task_Id=?2",nativeQuery=true)
	void updateProjectStatus(String status, Long taskId);
}
