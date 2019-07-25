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
import com.pmt.app.model.ParentTask;
import com.pmt.app.model.User;
import com.pmt.app.repository.UserRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestParentTaskRepository {
	
	JSONArray userList; 
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ParentTaskRepository repository; 

    @Before
	public void setUp() throws Exception {
 
	}
    
	@Test 
	public void contextLoads() {
	}
	@Test
	public void testSave() {
		
		ParentTask parentTask = new ParentTask();
		parentTask.setTitle("Parent Task");
		
		repository.save(parentTask);
		entityManager.persist(parentTask);  
		
	}
	
	@Test
    public void testFindAll() {
		
		repository.deleteAll();
		
		ParentTask parentTask = new ParentTask();
		parentTask.setTitle("Parent Task");
		
		
        entityManager.persist(parentTask); 
        
        List<ParentTask> parentTaskOut = repository.findAll();
        assertEquals( parentTaskOut.size(),1);
				
    }
}
