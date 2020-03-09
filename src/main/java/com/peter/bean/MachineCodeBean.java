package com.peter.bean;

public class MachineCodeBean {

	private Integer machineCodeId;
	private String description;
	private Double hourlyRate;
	private Integer maxHours;
	public Integer getMachineCodeId() {
		return machineCodeId;
	}
	public void setMachineCodeId(Integer machineCodeId) {
		this.machineCodeId = machineCodeId;
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
