package com.peter.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.peter.model.User;

import com.peter.dao.GenericDao;


@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements GenericService {
	
	@Autowired
	@Qualifier("userDao")
	GenericDao dao;
	
	private static List<User> users;
	
	static {
		users = populateDummyUsers();
	}

	
	public User findByName(String name ) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}
	
	private static List<User> populateDummyUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User("Admin", "Admin123",'A'));
		users.add(new User("Contractor", "Contractor123",'C'));
		return users;
		
	}
	
	
	@Override
	public <E> void add(E object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <E> List<E> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> E get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
