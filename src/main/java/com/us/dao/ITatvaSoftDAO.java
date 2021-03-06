package com.us.dao;

import java.util.List;

/**
 * 
 * @author TatvaSoft
 * 
 */
public interface ITatvaSoftDAO<T,ID> {
    
	public void save(T t);
	
    public void persist(T t);

    public T find(ID key);
    
    public List<T> findAll();
    
    public void delete(ID key);
}