package com.us.service;

import com.us.entity.User;

public interface IUserService {
	User authenticateUser(String userName,String password);
}
