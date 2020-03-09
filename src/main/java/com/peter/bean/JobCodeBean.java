package com.peter.bean;

public class JobCodeBean {

	private Integer id;
	private String description;
	private Double hourlyRate;
	private Integer maxHours;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
