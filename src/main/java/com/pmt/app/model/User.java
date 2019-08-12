package com.pmt.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class User { 
	

@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", employeeId="
				+ employeeId + ", tasks=" + tasks + "]";
	}
/**	UserId INT NOT NULL AUTO_INCREMENT,
	 FirstName VARCHAR(50) NOT NULL, 
	 LastName VARCHAR(50) NOT NULL,
	 EmployeeId VARCHAR(20) NOT NULL, **/
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long userId;
	@NotNull
	 private String firstName;
	@NotNull
	 private String lastName;
	@NotNull
	 private String employeeId;
	
	 @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Task> tasks = new ArrayList<>();
	 
	
	 
		 
	 
	 public User(String firstName, String lastName, String employeeId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
	} 
	public User() {
		// TODO Auto-generated constructor stub
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
