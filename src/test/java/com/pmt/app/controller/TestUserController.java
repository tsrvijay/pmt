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
import com.pmt.app.controller.service.UserService;
import com.pmt.app.model.User;
 

public class TestUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestUserController.class);
	
	@Mock
    UserService userService; 
	
	@InjectMocks 
    UserController userController;
 
    MockMvc mockMvc;
    
    JSONArray userList; 
    
 
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        this.userList = Utils.jsonParsar("src/test/resources/User.json"); // Loads the test data
    }
 

	@Test
	public final void testFindByFirstName() throws Exception {
		this.mockMvc.perform(get("/User/findByFirstName/Vijay")).andExpect(status().isOk());
	}
	
	@Test
	public final void testFindAll() throws Exception {
		this.mockMvc.perform(get("/User/findAll/firstName")).andExpect(status().isOk());
	}
	
	@Test
	public final void testSaveSingleEntity() throws Exception {
		
		User mockuser = new User("firstName", "Last Name", "emp1");

	    // studentService.addCourse to respond back with mockCourse
	    Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(mockuser);
	    
	    ObjectMapper Obj = new ObjectMapper(); 
	    String jsonContent = Obj.writeValueAsString(mockuser);

	    // Send course as body to /students/Student1/courses
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .post("/User/save")
	            .accept(MediaType.APPLICATION_JSON)
	            .content(jsonContent)
	            .contentType(MediaType.APPLICATION_JSON);

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		
	//	this.mockMvc.perform(get("/User/delete/firstName")).andExpect(status().isOk());
	}

	@Test
	public final void testDelete() throws Exception {
		
		User mockuser = new User("firstName", "Last Name", "emp1");

	    // studentService.addCourse to respond back with mockCourse
	    Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(mockuser);
	    
	    ObjectMapper Obj = new ObjectMapper(); 
	    String jsonContent = Obj.writeValueAsString(mockuser);

	    // Send course as body to /students/Student1/courses
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .post("/User/delete")
	            .accept(MediaType.APPLICATION_JSON)
	            .content(jsonContent)
	            .contentType(MediaType.APPLICATION_JSON);

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		
	//	this.mockMvc.perform(get("/User/delete/firstName")).andExpect(status().isOk());
	}

	@SuppressWarnings("unchecked")
	@Test
	public final void testSave() throws Exception {
		
		
		this.userList.forEach(
			emp -> {
				JSONObject user= (JSONObject) emp;
				User userModel = new User();
				userModel.setUserId(((Long)user.get("userId")).intValue());
				userModel.setEmployeeId((String)user.get("empoyeeId"));
				userModel.setFirstName((String)user.get("firstName"));
				userModel.setLastName((String)user.get("lastName"));
				try {
//					this.mockMvc.perform(post("/User/save").content("{json}")
//							.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
//							.andExpect(status().isCreated());
					userService.save(userModel);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}  
		);
	}
	
	
	
	

}
