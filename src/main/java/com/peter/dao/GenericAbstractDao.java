package com.peter.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericAbstractDao implements GenericDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public <E> void save(E object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(object);
	}
}
