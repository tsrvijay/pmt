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
import com.pmt.app.controller.service.UserService;
import com.pmt.app.model.Project;
import com.pmt.app.model.User;
 

public class TestProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestProjectController.class);
	
	@Mock
    ProjectService projectService; 
	
	@InjectMocks 
    ProjectController projectController;
 
    MockMvc mockMvc;
    
    JSONArray userList; 
    
 
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
        this.userList = Utils.jsonParsar("src/test/resources/User.json"); // Loads the test data
    }

	
	@Test
	public final void testFindAll() throws Exception {
		this.mockMvc.perform(get("/Project/findAll/projectName")).andExpect(status().isOk());
	}
	@Test
	public final void testUpdateProjectStatus() throws Exception {
		
		
		Project project = Utils.constructProjectObject();

	    // studentService.addCourse to respond back with mockCourse
	    Mockito.when(projectService.save(Mockito.any(Project.class))).thenReturn(project);
	    
	    ObjectMapper Obj = new ObjectMapper(); 
	    String jsonContent = Obj.writeValueAsString(project);

	    // Send course as body to /students/Student1/courses
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .post("/Project/updateStatus")
	            .accept(MediaType.APPLICATION_JSON)
	            .content(jsonContent)
	            .contentType(MediaType.APPLICATION_JSON);

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		
	}
	
	@Test
	public final void testDelete() throws Exception {
		
		Project project = Utils.constructProjectObject();

	    // studentService.addCourse to respond back with mockCourse
	    Mockito.when(projectService.save(Mockito.any(Project.class))).thenReturn(project);
	    
	    ObjectMapper Obj = new ObjectMapper(); 
	    String jsonContent = Obj.writeValueAsString(project);

	    // Send course as body to /students/Student1/courses
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .post("/Project/delete")
	            .accept(MediaType.APPLICATION_JSON)
	            .content(jsonContent)
	            .contentType(MediaType.APPLICATION_JSON);

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}

	@SuppressWarnings("unchecked")
	@Test
	public final void testSave() throws Exception {
		
		Project project = Utils.constructProjectObject();
		try {
			projectService.save(project);
		    ObjectMapper Obj = new ObjectMapper(); 
		    String jsonContent = Obj.writeValueAsString(project);
			
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders
		            .post("/Project/save")
		            .accept(MediaType.APPLICATION_JSON)
		            .content(jsonContent)
		            .contentType(MediaType.APPLICATION_JSON);

		    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		    MockHttpServletResponse response = result.getResponse();

		    assertEquals(HttpStatus.OK.value(), response.getStatus());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
