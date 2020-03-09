package com.peter.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peter.model.JobCode;


@Repository("jobCodeDao")
public class JobCodeDaoImpl extends GenericAbstractDao{

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public <E> List<E> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(JobCode.class).list();
	}

	@Override
	public JobCode get(int id) {
		// TODO Auto-generated method stub
		return (JobCode) sessionFactory.getCurrentSession().get(JobCode.class, id);
	}

	@Override
	public <E> void delete(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM disaster_jobcode WHERE id=" + id).executeUpdate();
	}

}
