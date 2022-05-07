package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Authentication;


@Repository
public interface AuthenticationDAO {
	public List<Authentication> findAllUsers();
	public void addLogin(Authentication loginScreen);
	public boolean checkLogin(String userName, String passWord);	
    public boolean deleteLogin(int id);
    public Authentication findLogin(int id);
}
