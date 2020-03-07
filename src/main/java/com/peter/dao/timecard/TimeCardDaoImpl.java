package com.peter.dao.timecard;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.peter.model.MachineCode;
import com.peter.model.TimeCard;

public class TimeCardDaoImpl implements TimeCardDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addTimeCard(TimeCard timeCard) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(timeCard);
	}

	@Override
	public List<TimeCard> getTimeCards() {
		// TODO Auto-generated method stub
		return (List<TimeCard>) sessionFactory.getCurrentSession().createCriteria(TimeCard.class).list();
	}

	@Override
	public TimeCard getTimeCard(int timeCardId) {
		// TODO Auto-generated method stub
		return (TimeCard) sessionFactory.getCurrentSession().get(TimeCard.class, timeCardId);
	}

	@Override
	public void deleteTimeCard(TimeCard timeCard) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM disaster_timecard WHERE id=" + timeCard.getTimeCardId()).executeUpdate();
	}

}
