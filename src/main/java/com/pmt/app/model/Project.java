package com.pmt.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Project {
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", priority=" + priority + ", status=" + status + ", noOfTasks=" + noOfTasks
				+ ", completedTasks=" + completedTasks + ", manager=" + manager + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;
	@NotNull
	String projectName;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	Date startDate;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	Date endDate;
	
	int priority;
	private String status;
	
	int noOfTasks;
	
	int completedTasks;
	
	public int getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	//Manager info
	@NotNull
	@OneToOne
	private User manager;
	
	

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public User getUser() {
		return manager;
	}

	public void setUser(User user) {
		this.manager = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNoOfTasks() {
		return noOfTasks;
	}

	public void setNoOfTasks(int noOfTasks) {
		this.noOfTasks = noOfTasks;
	}

	

}
