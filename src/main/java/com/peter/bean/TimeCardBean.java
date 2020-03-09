package com.peter.bean;

public class TimeCardBean {

	private Integer timeCodeId;
	private String siteCode;
	private String contractorName;
	private Integer totalHours;
	private Double totalAmount;
	private String approval;
	
	public Integer getTimeCodeId() {
		return timeCodeId;
	}
	public void setTimeCodeId(Integer timeCodeId) {
		this.timeCodeId = timeCodeId;
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
	public Integer getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
}
