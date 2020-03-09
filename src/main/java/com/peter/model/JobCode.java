package com.peter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="disaster_jobcode")
public class JobCode implements Serializable {

	private static final long serialVersionUID = 123L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int jobCodeId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "rate per hour")
	private double hourlyRate;
	
	@Column(name = "max daily hours")
	private int maxHours;

	public int getJobCodeId() {
		return jobCodeId;
	}

	public void setJobCodeId(int jobCodeId) {
		this.jobCodeId = jobCodeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getMaxHours() {
		return maxHours;
	}

	public void setMaxHours(int maxHours) {
		this.maxHours = maxHours;
	}
}
