package com.pmt.app.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmt.app.Utils;
import com.pmt.app.controller.service.ProjectService;
import com.pmt.app.controller.service.TaskService;
import com.pmt.app.controller.service.UserService;
import com.pmt.app.model.ParentTask;
import com.pmt.app.model.Project;
import com.pmt.app.model.Task;
import com.pmt.app.model.User;
 

public class TestTaskController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestTaskController.class);
	
	@Mock
    TaskService projectService; 
	
	@InjectMocks 
    TaskController projectController;
 
    MockMvc mockMvc;
    
    
 
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
    }

	
	@Test
	public final void testFindAll() throws Exception {
		this.mockMvc.perform(get("/Task/findAll/task")).andExpect(status().isOk());
	}
	@Test
	public final void testParentFindAll() throws Exception {
		this.mockMvc.perform(get("/ParentTask/findAll/title")).andExpect(status().isOk());
	}
	@Test
	public final void testTaskFindByProjectId() throws Exception {
		this.mockMvc.perform(get("/Task/findByProjectId/1")).andExpect(status().isOk());
	}
	@Test
	public final void testParentTaskFindByProjectId() throws Exception {
		this.mockMvc.perform(get("/ParentTask/findAll/1")).andExpect(status().isOk());
	}
	
	@Test
	public final void testUpdateTaskStatus() throws Exception {
		
		
		Task task = Utils.constructTaskObject();

	    
	    ObjectMapper Obj = new ObjectMapper(); 
	    String jsonContent = Obj.writeValueAsString(task);

	    // Send course as body to /students/Student1/courses
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .post("/Task/updateStatus")
	            .accept(MediaType.APPLICATION_JSON)
	            .content(jsonContent)
	            .contentType(MediaType.APPLICATION_JSON);

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		
	}
	
	@Test
	public final void testDelete() throws Exception {
		
		Task project = Utils.constructTaskObject();

	    ObjectMapper Obj = new ObjectMapper(); 
	    String jsonContent = Obj.writeValueAsString(project);

	    // Send course as body to /students/Student1/courses
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .post("/Task/delete")
	            .accept(MediaType.APPLICATION_JSON)
	            .content(jsonContent)
	            .contentType(MediaType.APPLICATION_JSON);

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}
	
	@Test
	public final void testTaskSave() throws Exception {
		
		Task project = Utils.constructTaskObject();

	    ObjectMapper Obj = new ObjectMapper(); 
	    String jsonContent = Obj.writeValueAsString(project);

	    // Send course as body to /students/Student1/courses
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .post("/Task/save")
	            .accept(MediaType.APPLICATION_JSON)
	            .content(jsonContent)
	            .contentType(MediaType.APPLICATION_JSON);

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}
	
	@Test
	public final void testParentTaskSave() throws Exception {
		
		ParentTask project = Utils.constructParentTaskObject();

	    ObjectMapper Obj = new ObjectMapper(); 
	    String jsonContent = Obj.writeValueAsString(project);

	    // Send course as body to /students/Student1/courses
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .post("/ParentTask/save")
	            .accept(MediaType.APPLICATION_JSON)
	            .content(jsonContent)
	            .contentType(MediaType.APPLICATION_JSON);

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}
	
	@Test
	public final void testParentTaskSaveException() throws Exception {
		
		ParentTask project = null;

	    ObjectMapper Obj = new ObjectMapper(); 
	    String jsonContent = Obj.writeValueAsString(project);

	    // Send course as body to /students/Student1/courses
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .post("/ParentTask/save")
	            .accept(MediaType.APPLICATION_JSON)
	            .content(jsonContent)
	            .contentType(MediaType.APPLICATION_JSON);

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    
		
	}


	@SuppressWarnings("unchecked")
	@Test
	public final void testSave() throws Exception {
		
		Task project = Utils.constructTaskObject();
		try {
			projectService.save(project);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public final void testSaveException() throws Exception {
		
		Task project = null;
		try {
			projectService.save(project);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public final void testParentSave() throws Exception {
		
		ParentTask project = Utils.constructParentTaskObject();
		try {
			projectService.save(project);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
