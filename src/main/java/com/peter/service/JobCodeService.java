package com.peter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.peter.dao.GenericDao;

@Service("jobCodeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class JobCodeService implements GenericService{

	@Autowired
	@Qualifier("jobCodeDao")
	GenericDao dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public <E> void add(E object) {
		// TODO Auto-generated method stub
		dao.save(object);
	}

	@Override
	public <E> List<E> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public <E> E get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

}
