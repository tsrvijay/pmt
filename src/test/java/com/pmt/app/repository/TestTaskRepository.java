package com.pmt.app.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pmt.app.Utils;
import com.pmt.app.model.ParentTask;
import com.pmt.app.model.Project;
import com.pmt.app.model.Task;
import com.pmt.app.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestTaskRepository {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private ProjectRepository repository; 
	    
	@Autowired
	private TaskRepository taskRepository; 

	@Autowired
	private ParentTaskRepository parentTaskRepository; 

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testSave() {
		Project project = Utils.constructProjectObject();
		
		ParentTask pt=  Utils.constructParentTaskObject();
		
		
		 
		User user =entityManager.persist(Utils.constructUserObject());
		project.setUser(user);
		project =entityManager.persist(project);
		
		Task task = Utils.constructTaskObject(pt, user, project);
		pt=  entityManager.persist(pt);
		Task taskOut  = entityManager.persist(task);
		System.out.println(taskOut.toString());
		
		List<Task> taskOut1= taskRepository.findAll();
		 assertEquals( taskOut1.size(),1);
		
	}

}
