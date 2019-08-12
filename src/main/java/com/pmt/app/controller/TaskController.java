package com.pmt.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmt.app.controller.service.TaskService;
import com.pmt.app.model.ParentTask;
import com.pmt.app.model.Project;
import com.pmt.app.model.Task;

@CrossOrigin(origins = "*")
@RestController 
public class TaskController {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

	@Autowired
    private TaskService service;
	
	@GetMapping("/Task/findAll/{sortby}")
	public List<Task> findAll(@PathVariable String sortby){
		List<Task> list = null;
		try {
			logger.info("Calling Task service : ");
			list = service.findAll(sortby);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
		return list;
	}
	@GetMapping("/ParentTask/findAll/{projectId}")
	public List<ParentTask> findParentTask(@PathVariable String projectId){
		List<ParentTask> list = null;
		try {
			logger.info("Calling Task service : ");
			list = service.findParentTask(projectId);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
		return list;
	}
	
	@PostMapping("/Task/updateStatus")
	public void updateStatus(@RequestBody Task task){
		
		try {
			logger.info("Calling Task service : ");
			service.updateProjectStatus(task); 
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
	}
	@GetMapping("/Task/findByProjectId/{projectId}")
	public List<Task> findTask(@PathVariable String projectId){
		List<Task> list = null;
		try {
			logger.info("Calling Task service : ");
			list = service.findTask(projectId);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
		return list;
	}
	@PostMapping("/Task/save")
	public void save(@RequestBody Task task){
		
		try {
			logger.info("Calling Task service : ");
			service.save(task);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
		
	}
	
	@PostMapping("/ParentTask/save")
	public void save(@RequestBody ParentTask task){
		
		try {
			logger.info("Calling Parent Task service : ");
			service.save(task);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
		
	}
	
	@PostMapping("/Task/delete")
	public void delete(@RequestBody Task task){
		
		try {
			logger.info("Calling Task service : ");
			service.delete(task);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
	}
	
}
