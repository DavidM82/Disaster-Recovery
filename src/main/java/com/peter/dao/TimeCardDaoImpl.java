package com.peter.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peter.model.TimeCard;

@Repository("timeCardDao")
public class TimeCardDaoImpl extends GenericAbstractDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public <E> List<E> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(TimeCard.class).list();
	}

	@Override
	public TimeCard get(int id) {
		// TODO Auto-generated method stub
		return (TimeCard) sessionFactory.getCurrentSession().get(TimeCard.class, id);
	}

	@Override
	public <E> void delete(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM TimeCard timecard WHERE timecard.timeCardId=" + id).executeUpdate();
	}
}