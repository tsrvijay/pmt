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
import com.pmt.app.controller.service.TaskService;
import com.pmt.app.controller.service.UserService;
import com.pmt.app.model.ParentTask;
import com.pmt.app.model.Project;
import com.pmt.app.model.Task;
import com.pmt.app.model.User;
import com.pmt.app.repository.ParentTaskRepository;
import com.pmt.app.repository.ProjectRepository;
import com.pmt.app.repository.TaskRepository;
import com.pmt.app.repository.UserRepository;

public class TestTaskService {
	
	@InjectMocks
    TaskService userService;
	@Mock
	TaskRepository repository;
	@Mock
	ParentTaskRepository parentRepository;
	
	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userService).build();
 
		 
	}

	@Test
	public final void testSave() {
		Task project = Utils.constructTaskObject();
		userService.save(project);
		userService.delete(project);
		userService.findAll();
		userService.findParentTask("1");
		userService.findTask("1");
		userService.updateProjectStatus("suspend", new Long(1));
	}

	@Test
	public final void testParentSave() {
		ParentTask project = Utils.constructParentTaskObject();
		userService.save(project);
		//assertEquals(user, userOut);
	}
	
	
	
	@Test
	public final void testFindAll() {
		userService.findAll("task");
	}
	
}
