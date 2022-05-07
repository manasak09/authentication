package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Authentication;


@Component
public class AuthenticationDAOImpl implements AuthenticationDAO{
	
@Autowired
SessionFactory sessionFactory;

	@Override
	public void addLogin(Authentication loginScreen) {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.openSession();
			
			session.getTransaction().begin();
			session.save(loginScreen);
			session.flush();
			session.getTransaction().commit();
			session.close();
		
	}


	@Override
	public boolean checkLogin(String userName, String passWord) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		org.hibernate.query.Query query= session.createQuery("select i from Authentication i where userName=:uname and passWord=:pass");
		query.setParameter("uname", userName);
		query.setParameter("pass", passWord);
		//query.setParameter("gmail.com", emailId);
		List list=query.list();
		if(list.size()>0) {
			return true;
		}
		else {
		return false;
		}
		
	}


	@Override
	public List<Authentication> findAllUsers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List<Authentication> userlist=session.createQuery("Select I from Authentication I").list();
		return userlist;
	}


	


	@Override
	public boolean deleteLogin(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Authentication loginScreen=session.find(Authentication.class, id);
		session.getTransaction().begin();
		session.delete(loginScreen);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}


	@Override
	public Authentication findLogin(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Authentication loginScreen=session.find(Authentication.class, id);
		return loginScreen;
	}


}
