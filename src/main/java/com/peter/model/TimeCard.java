package com.peter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disaster_timecard")
public class TimeCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int timeCardId;
	
	@Column(name = "site code")
	private String siteCode;
	
	@Column(name = "Contractor Name")
	private String contractorName;
	
	@Column(name = "Total hours")
	private int totalHours;
	
	@Column(name = "Total Amount")
	private double totalAmount;
	
	@Column(name = "Approval")
	private String approval;

	public int getTimeCardId() {
		return timeCardId;
	}

	public void setTimeCardId(int timeCardId) {
		this.timeCardId = timeCardId;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

}
