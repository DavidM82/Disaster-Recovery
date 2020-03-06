package com.peter.dao.jobcode;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peter.model.JobCode;

@Repository("jobCodeDao")
public class JobCodeDaoImpl implements JobCodeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addJobCode(JobCode jobcode) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(jobcode);
	}

	@Override
	public List<JobCode> getJobCodes() {
		// TODO Auto-generated method stub
		return (List<JobCode>) sessionFactory.getCurrentSession().createCriteria(JobCode.class).list();
	}

	@Override
	public JobCode getJobCode(int jobCodeId) {
		// TODO Auto-generated method stub
		return (JobCode) sessionFactory.getCurrentSession().get(JobCode.class, jobCodeId);
	}

	@Override
	public void deleteJobCode(JobCode jobcode) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM disaster_jobcode WHERE id=" + jobcode.getJobCodeId()).executeUpdate();
	}

}
