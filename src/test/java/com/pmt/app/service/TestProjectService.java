package com.pmt.app.service;

import java.util.Date;

import org.json.simple.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pmt.app.Utils;
import com.pmt.app.controller.service.ProjectService;
import com.pmt.app.controller.service.UserService;
import com.pmt.app.model.Project;
import com.pmt.app.model.User;
import com.pmt.app.repository.ProjectRepository;
import com.pmt.app.repository.UserRepository;

public class TestProjectService {
	
	@InjectMocks
    ProjectService userService;
	@Mock
	ProjectRepository repository;
	
	
	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userService).build();
 
		 
	}

	@Test
	public final void testSave() {
		Project project = constructObject();
		Project userOut= userService.save(project);
		//assertEquals(user, userOut);
	}

	private Project constructObject() {
		Project project = new Project();
		project.setProjectName("PMT");
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setManager(new User());
		project.setNoOfTasks(10);
		project.setCompletedTasks(5);
		project.setStatus("Completed");
		return project;
	}
	
	@Test
	public final void testDelete() {
		Project project = constructObject();
		userService.delete(project);
	}
	
	@Test
	public final void testFindAll() {
		userService.findAll("projectName");
	}
	
	
	
//	public List<User> findByFirstName(String firstName){
//		return repository.findByFirstName(firstName);
//	}
//	public User save(User user){
//		return repository.save(user);
//	}
//	public void delete(User user){
//		repository.delete(user);
//	}
//	public List<User> findAll(String sortby){
//		return repository.findAll(Sort.by(Sort.Direction.ASC, sortby));
//	}

}
