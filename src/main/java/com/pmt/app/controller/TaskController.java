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
import com.pmt.app.model.Task;

@CrossOrigin(origins = "http://localhost:4200")
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
	@PostMapping("/Task/save")
	public void save(@RequestBody Task task){
		
		try {
			logger.info("Calling Task service : ");
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