package com.pmt.app.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class ParentTask {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long parentTaskId;
	@NotNull
	String title;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	Project project;
	
	public long getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
