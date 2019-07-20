package com.pmt.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pmt.app.controller.service.UserService;
 

public class TestUserController {
	
	@Mock
    UserService userService; 
	
	@InjectMocks 
    UserController userController;
 
    MockMvc mockMvc;
 
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
 

	@Test
	public final void testFindByFirstName() throws Exception {
		this.mockMvc.perform(get("/User/Vijay")).andExpect(status().isOk());
	}

}
