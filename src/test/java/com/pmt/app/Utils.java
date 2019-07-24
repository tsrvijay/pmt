package com.pmt.app;

import java.io.FileReader;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pmt.app.controller.UserController;
import com.pmt.app.model.Project;
import com.pmt.app.model.User;

public class Utils {
	
	private static final Logger logger = LoggerFactory.getLogger(Utils.class);
	public static JSONArray jsonParsar(String resourcePath){
		JSONArray userList = null;
		JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(resourcePath))
        { 
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            System.out.println("Inside.reader.");
            userList = (JSONArray) obj;
        } catch (Exception e) {
        	logger.error("Exception : " + e);
        } 
        
        return userList;
	}
	public static Project constructProjectObject() {
		Project project = new Project();
		project.setProjectName("PMT");
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setManager(new User());
		project.setNoOfTasks(10);
		project.setCompletedTasks(5);
		project.setStatus("Completed");
		project.setUser(constructUserObject());
		return project;
	}
	
	public static User constructUserObject() {
		User user = new User();
		user.setFirstName("firstName");	
		user.setLastName("firstName");
		user.setEmployeeId("EmpId001");
		return user;
	}

}
