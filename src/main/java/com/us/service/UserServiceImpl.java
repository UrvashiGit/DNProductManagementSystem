package com.us.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.us.dao.IUserDAO;
import com.us.entity.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserDAO userDao;
	
	public User authenticateUser(String userName,String password) {
		return userDao.authenticateUser(userName, password);
	}

}
