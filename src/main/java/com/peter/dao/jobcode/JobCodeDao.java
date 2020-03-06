package com.peter.dao.jobcode;

import java.util.List;

import com.peter.model.JobCode;

public interface JobCodeDao {

	public void addJobCode(JobCode jobcode);
	
	public List<JobCode> getJobCodes();
	
	public JobCode getJobCode(int jobCodeId);
	
	public void deleteJobCode(JobCode jobcode);
}
