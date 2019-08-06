package com.pmt.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pmt.app.model.ParentTask;



public interface ParentTaskRepository extends JpaRepository<ParentTask, Long>{
	@Query(value ="Select * from Parent_Task pt where pt.project_id =?1",nativeQuery=true)
	List<ParentTask> findByProjectId(String projectId);

}
