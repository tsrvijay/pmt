package com.pmt.app.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pmt.app.model.ParentTask;
import com.pmt.app.model.Project;
import com.pmt.app.model.Task;
import com.pmt.app.repository.ParentTaskRepository;
import com.pmt.app.repository.ProjectRepository;
import com.pmt.app.repository.TaskRepository;
 @Service
public class TaskService {
	
	@Autowired
    private TaskRepository repository;
	
	@Autowired
    private ProjectRepository projectRepository;
	
	@Autowired
    private ParentTaskRepository parentRepository;
	
	public void save(Task task){
		if(task.getParentTask() == null) {
			parentRepository.save(task.getParentTask());
		}else {
			repository.save(task);
			
		}
		System.out.println("Task :" + task.toString());
		
		projectRepository.updateProjectTaskCount(task.getProject().getProjectId());
	}
	
	public void save(ParentTask task){
			parentRepository.save(task);
	}
	public void delete(Task task){
		repository.delete(task);
	}
	public List<Task> findAll(String sortby){
		return repository.findAll(Sort.by(Sort.Direction.ASC, sortby));
	}
	public List<ParentTask> findParentTask(String projectId){
		return parentRepository.findByProjectId(projectId);
	}
	
	public List<Task> findTask(String projectId){
		Project p = new Project();
		p.setProjectId(Long.parseLong(projectId));
		return repository.findByProjectId(Long.parseLong(projectId));
	}
	public List<ParentTask> findAll(){
		return parentRepository.findAll();
	}
	public void updateProjectStatus(Task task) {
		repository.updateProjectStatus(task.getStatus(),task.getTaskId());
		projectRepository.updateProjectCompletedTaskCount(task.getProject().getProjectId());
	}
}
