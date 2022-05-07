package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Authentication;

@Service
public class AuthenticationService {
	@Autowired
	AuthenticationDAO loginScreenDAOImpl;
	 public void addLogin(Authentication loginScreen) {
		 loginScreenDAOImpl.addLogin(loginScreen);
	}

	
	public boolean checkLogin(String userName, String passWord) {
		// TODO Auto-generated method stub
		return loginScreenDAOImpl.checkLogin(userName, passWord);
	}
	public List<Authentication> findAllUsers(){
		return  loginScreenDAOImpl.findAllUsers();	
	}
	
	public Authentication findLogin(int id) {
		return loginScreenDAOImpl.findLogin(id);
	}
	
	public boolean deleteLogin(int id) {
		return loginScreenDAOImpl.deleteLogin(id);
	}
	}


