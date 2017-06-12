package com.us.dao;

import com.us.entity.User;

public interface IUserDAO {
	User authenticateUser(String userName,String password);
}
