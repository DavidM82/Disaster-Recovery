package com.peter.bean;

public class JobCodeBean {

	private Integer jobCodeId;
	private String jobCode;
	private String description;
	private Double hourlyRate;
	private Integer maxHours;

	public Integer getJobCodeId() {
		return jobCodeId;
	}
	public void setJobCodeId(Integer id) {
		this.jobCodeId = id;
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
	public Double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public Integer getMaxHours() {
		return maxHours;
	}
	public void setMaxHours(Integer maxHours) {
		this.maxHours = maxHours;
	}
}
