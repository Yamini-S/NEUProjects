package com.neu.edu.dao;

import org.hibernate.Query;
import org.hibernate.HibernateException;

import com.neu.edu.model.LoginUser;
import com.neu.edu.model.Role;
import com.neu.edu.exception.AddException;;

public class LoginUserDAO extends DAO {

	public LoginUserDAO() {

	}

	public LoginUser addLoginUser(LoginUser loginUser) throws AddException {
		try {
			begin();

			getSession().save(loginUser);
			commit();
			return loginUser;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AddException("Exception while creating user: " + e.getMessage());
		}
	}

	public LoginUser getLoginUser(String username) throws AddException {

		try {
			begin();
			Query q = getSession().createQuery("from LoginUser where username = :username and password=:password");
			q.setString("username", username);
			LoginUser loginUser = (LoginUser) q.uniqueResult();
			commit();
			return loginUser;
		} catch (HibernateException e) {
			rollback();
			throw new AddException("Could not get user " + username, e);
		}
	}
	
	
	public boolean checkLoginUser(String username) {
            
		    begin();
			Query q = getSession().createQuery("from LoginUser where username = :username");
			q.setString("username", username);
			LoginUser loginUser = (LoginUser) q.uniqueResult();
			//commit();
			
			if(loginUser == null){
				getSession().close();
				return true;
			}
			else{
				getSession().close();
				return false;
			}
		
	}

	public LoginUser getLoginUser(String username, String password) throws AddException {

		try {
			begin();
			Query q = getSession().createQuery("from LoginUser where username = :username and password=:password");
			q.setString("username", username);
			q.setString("password", password);
			LoginUser loginUser = (LoginUser) q.uniqueResult();
			commit();
			return loginUser;
		} catch (HibernateException e) {
			rollback();
			throw new AddException("Could not get user " + username, e);
		}
	}

	public void deleteLoginUser(LoginUser loginUser) throws AddException {
		try {
			begin();
			getSession().delete(loginUser);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AddException("Could not delete user " + loginUser.getUsername(), e);
		}

	}
}
