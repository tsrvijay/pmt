package com.pmt.app.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pmt.app.model.Task;
import com.pmt.app.repository.ParentTaskRepository;
import com.pmt.app.repository.TaskRepository;
 @Service
public class TaskService {
	
	@Autowired
    private TaskRepository repository;
	
	@Autowired
    private ParentTaskRepository parentRepository;
	
	public void save(Task task){
		
		if(task.getTask() == null) {
			parentRepository.save(task.getParentTask());
			
		}else {
			
			if (task.getParentTask() != null) {
				parentRepository.save(task.getParentTask());
			}
			repository.save(task);
		}
		
	}
	public void delete(Task task){
		repository.delete(task);
	}
	public List<Task> findAll(String sortby){
		return repository.findAll(Sort.by(Sort.Direction.ASC, sortby));
	}
	
}
