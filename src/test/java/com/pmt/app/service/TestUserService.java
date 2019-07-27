package com.pmt.app.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pmt.app.Utils;
import com.pmt.app.controller.service.UserService;
import com.pmt.app.model.User;
import com.pmt.app.repository.UserRepository;

public class TestUserService {
	
	@InjectMocks
    UserService userService;
	@Mock
	UserRepository repository;
	
	JSONArray userList; 
	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userService).build();
 
		this.userList = Utils.jsonParsar("src/test/resources/User.json"); 
	}

	@Test
	public final void testSave() {
		User user = new User("firstName","lastName","emp1");
		
		User userOut= userService.save(user);
		//assertEquals(user, userOut);
	}
	
	@Test
	public final void testSearch() {
		User user = new User("firstName","lastName","emp1");
		
		User userOut= userService.save(user);
		
		List<User> list = userService.search("firstName");
		//assertEquals(user, userOut);
	}
	
	@Test
	public final void testDelete() {
		User user = new User("firstName","lastName","emp1");
		userService.delete(user);
	}
	
	@Test
	public final void testFindAll() {
		userService.findAll("userId");
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
