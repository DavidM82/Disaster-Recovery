package com.peter.dao.timecard;

import java.util.List;

import com.peter.model.TimeCard;

public interface TimeCardDao {

	public void addTimeCard(TimeCard timecard);
	
	public List<TimeCard> getTimeCards();
	
	public TimeCard getTimeCard(int timeCardId);
	
	public void deleteTimeCard(TimeCard timeCard);
}
