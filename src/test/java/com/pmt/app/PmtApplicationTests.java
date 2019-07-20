package com.pmt.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pmt.app.model.User;
import com.pmt.app.repository.UserRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class PmtApplicationTests {
	
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository; 


	@Test 
	public void contextLoads() {
	}

	@Test
    public void testFindByName() {

        entityManager.persist(new User("Hari","Vijay","001")); 

        List<User> users = repository.findByFirstName("Hari");
        assertEquals(1, users.size());

        assertThat(users).extracting(User::getFirstName).containsOnly("Hari");
        assertThat(users).extracting(User::getLastName).containsOnly("Vijay");
        assertThat(users).extracting(User::getEmployeeId).containsOnly("001");
    }
}
