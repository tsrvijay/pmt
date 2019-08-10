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

import com.pmt.app.controller.service.ProjectService;
import com.pmt.app.model.Project;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class ProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
    private ProjectService service;
	
	@GetMapping("/Project/findAll/{sortby}")
	public List<Project> findAll(@PathVariable String sortby){
		List<Project> list = null;
		try {
			logger.info("Calling User service : ");
			list = service.findAll(sortby);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
		return list;
	}
	@PostMapping("/Project/save")
	public Project save(@RequestBody Project user){
		
		try {
			logger.info("Calling Project service : ");
			user = service.save(user);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
		return user;
	}
	
	@PostMapping("/Project/delete")
	public void delete(@RequestBody Project user){
		
		try {
			logger.info("Calling Project service : ");
			service.delete(user);
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
	}
	
	@PostMapping("/Project/updateStatus")
	public void updateStatus(@RequestBody Project project){
		
		try {
			logger.info("Calling Project service : ");
			service.updateProjectStatus(project.getStatus(),new Long(project.getProjectId()));
		}catch(Exception e) {
			logger.error("Exception :" ,e);
		}
	}
	
}
