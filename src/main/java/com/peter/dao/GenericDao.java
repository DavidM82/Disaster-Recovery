package com.peter.dao;

import java.util.List;

public interface GenericDao {

	public <E> void save(E object);

	public <E> List<E> getAll();
	
	public <E> E get(int id);
	
	public <E> void delete(int id);
	
}
