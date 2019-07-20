package com.pmt.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User { 
	

/**	UserId INT NOT NULL AUTO_INCREMENT,
	 FirstName VARCHAR(50) NOT NULL,
	 LastName VARCHAR(50) NOT NULL,
	 EmployeeId VARCHAR(20) NOT NULL, **/
	 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	 private int userId;
	 private String firstName;
	 private String lastName;
	 private String employeeId;
	 
	 public User(String firstName, String lastName, String employeeId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
	} 
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	

}
