package com.peter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disaster_machinecode")
public class MachineCode implements Serializable {
	
	private static final long serialVersionUID = 12L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "machineCodeId")
	private int machineCodeId;
	
	@Column(name = "machineCode")
	private String machineCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "hourlyRate")
	private double hourlyRate;
	
	@Column(name = "maxHours")
	private int maxHours;

	public int getMachineCodeId() {
		return machineCodeId;
	}

	public void setMachineCodeId(int machineCodeId) {
		this.machineCodeId = machineCodeId;
	}

	public String getMachineCode() {
		return machineCode;
	}
	
	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
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
