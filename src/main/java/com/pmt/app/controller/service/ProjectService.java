package com.pmt.app.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pmt.app.model.Project;
import com.pmt.app.repository.ProjectRepository;
 @Service
public class ProjectService {
	
	@Autowired
    private ProjectRepository repository;
	
	public Project save(Project project){
		return repository.save(project);
	}
	public void delete(Project project){
		repository.delete(project);
	}
	public List<Project> findAll(String sortby){
		return repository.findAll(Sort.by(Sort.Direction.ASC, sortby));
	}
	public void updateProjectStatus(String status, Long projectId) {
		repository.updateProjectStatus(status,projectId);
	}
}
