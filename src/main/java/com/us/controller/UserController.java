package com.us.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.us.entity.User;
import com.us.service.IUserService;
import com.us.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/authenticateUser",method=RequestMethod.POST)
	public ModelAndView authenticateUser(HttpServletRequest request, HttpServletResponse response,@RequestParam("userName") String userName,
		@RequestParam("password") String password){
		System.out.println("UserName - "+userName+ "Password -- "+password);
		Integer id = null;
		User user = userService.authenticateUser(userName,password);
		ModelAndView model = new ModelAndView();
		
		if(user != null) {
			model.setViewName("home");
			model.addObject("loggedInUser",user);
		}else {
			model.setViewName("login");
			model.addObject("error","UserName or Password Incorrect");
		}
		return model;
	}
}