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
	@Column(name = "jobCodeId")
	private int jobCodeId;
	
	@Column(name = "jobCode")
	private String jobCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "hourlyRate")
	private double hourlyRate;
	
	@Column(name = "maxHours")
	private int maxHours;

	public int getJobCodeId() {
		return jobCodeId;
	}

	public void setJobCodeId(int jobCodeId) {
		this.jobCodeId = jobCodeId;
	}

	public String getJobCode() {
		return jobCode;
	}
	
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
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
