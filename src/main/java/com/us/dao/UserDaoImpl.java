package com.us.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.us.entity.User;

@Repository
public class UserDaoImpl extends TatvaSoftDAOImpl<User, Integer> implements IUserDAO{

	public UserDaoImpl() {
		super(User.class);
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public User authenticateUser(String userName,String password) {
		User user = null;
		try {
			String authenticationHQL = "from User where userName =  :userName and password = :password"; // Authentication
			// query

			Query query = sessionFactory.getCurrentSession().createQuery(
					authenticationHQL);
			query.setParameter("userName", userName);
			query.setParameter("password", password);

			List<User> userList = query.list();
			if(userList != null && userList.size() > 0){
				user = userList.get(0);
			}
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		return user;
	}

}
