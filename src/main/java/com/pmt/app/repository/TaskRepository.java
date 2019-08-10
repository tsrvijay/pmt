package com.pmt.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pmt.app.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long>{
	@Query(value ="Select pt from Task pt where pt.project.projectId=?1",nativeQuery=false)
	List<Task> findByProjectId(Long projectId);
	@Query(value ="update Task tk set status=?1 where tk.project.projectId=?1",nativeQuery=false)
	void updateProjectStatus(String status, Long projectId);
}
