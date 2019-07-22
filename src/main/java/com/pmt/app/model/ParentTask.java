package com.pmt.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ParentTask {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long parentTaskId;
	@NotNull
	String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
