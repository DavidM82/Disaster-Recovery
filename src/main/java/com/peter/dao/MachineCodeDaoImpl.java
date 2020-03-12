package com.peter.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peter.model.MachineCode;

@Repository("machineCodeDao")
public class MachineCodeDaoImpl extends GenericAbstractDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public <E> List<E> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(MachineCode.class).list();
	}

	@Override
	public MachineCode get(int id) {
		// TODO Auto-generated method stub
		return (MachineCode) sessionFactory.getCurrentSession().get(MachineCode.class, id);
	}

	@Override
	public <E> void delete(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM MachineCode machinecode WHERE machinecode.machineCodeId=" + id).executeUpdate();
	}

}