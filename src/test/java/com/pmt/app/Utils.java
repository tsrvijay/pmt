package com.pmt.app;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pmt.app.controller.UserController;

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

}
