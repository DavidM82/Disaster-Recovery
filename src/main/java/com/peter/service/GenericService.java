package com.peter.service;

import java.util.List;

public interface GenericService {

	public <E> void add(E object);

	public <E> List<E> getAll();
	
	public <E> E get(int id);
	
	public void delete(int id);
}
