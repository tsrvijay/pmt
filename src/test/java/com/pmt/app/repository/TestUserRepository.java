package com.pmt.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pmt.app.Utils;
import com.pmt.app.model.User;
import com.pmt.app.repository.UserRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestUserRepository {
	
	JSONArray userList; 
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository; 

    @Before
	public void setUp() throws Exception {
 
		this.userList = Utils.jsonParsar("src/test/resources/User.json"); 
	}
    
	@Test 
	public void contextLoads() {
	}

	@Test
    public void testFindByName() {
		User user = new User("Hari","Vijay","001");
        entityManager.persist(user); 

        List<User> users = repository.findByFirstName("Hari");
        assertEquals(1, users.size());

        assertThat(users).extracting(User::getFirstName).containsOnly("Hari");
        assertThat(users).extracting(User::getLastName).containsOnly("Vijay");
        assertThat(users).extracting(User::getEmployeeId).containsOnly("001");
        
        entityManager.detach(user);
        
    }
	
	@Test
    public void testFindAll() {
		
		repository.deleteAll();
		this.userList.forEach(
				emp -> {
					JSONObject user= (JSONObject) emp;
					User userModel = new User();
					//userModel.setUserId(((Long)user.get("userId")).intValue());
					userModel.setEmployeeId((String)user.get("employeeId"));
					userModel.setFirstName((String)user.get("firstName"));
					userModel.setLastName((String)user.get("lastName"));
			        entityManager.persist(userModel); 
				});
			        List<User> users = repository.findAll();
			        assertEquals(this.userList.size(), users.size());
			        
			
//			        assertThat(users).extracting(User::getFirstName).containsOnly("Hari");
//			        assertThat(users).extracting(User::getLastName).containsOnly("Vijay");
//			        assertThat(users).extracting(User::getEmployeeId).containsOnly("001");
				
    }
}
