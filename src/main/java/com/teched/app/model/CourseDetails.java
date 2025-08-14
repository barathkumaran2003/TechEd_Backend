package com.teched.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class CourseDetails {

	@Id
	private String id;

	private String name;
	private String description;
	private String duration;
	private String mode;
	private double fees;
	private List<String> technologies;
	private String demoVideo;

	@DBRef
	private TrainerDetails trainer;

	public CourseDetails() {
	}

	public CourseDetails(String id, String name, String description, String duration, String mode, double fees,
			List<String> technologies, String demoVideo) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.mode = mode;
		this.fees = fees;
		this.technologies = technologies;
		this.demoVideo = demoVideo;
	}

	public String getDemoVideo() {
		return demoVideo;
	}

	public void setDemoVideo(String demoVideo) {
		this.demoVideo = demoVideo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public List<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

}
