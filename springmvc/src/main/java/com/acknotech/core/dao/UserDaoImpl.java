package com.acknotech.core.dao;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.acknotech.core.dto.users.Users;
import com.acknotech.core.model.UsersVO;
import com.acknotech.core.services.UserService;


@Repository
public class UserDaoImpl implements UsersDao{
	
	

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	private UserService userService;
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserDaoImpl() {
		System.out.println("EmployeeDAOImpl");
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAllUsers() {
		Users user = null;
		Session session = null;
		List<Users> userData = null;

		try{
		session = this.sessionFactory.openSession();
		Query query = session
		.createQuery("from Users");
		
		userData = query.list();

		if (CollectionUtils.isNotEmpty(userData)) {
		   System.out.println("user found with is data");
		   user = (Users) userData.get(0);

		} else {
		   logger.info("no user found with user id={}", user);
		}
		   } catch(Exception e){
		   	e.printStackTrace();
		   } finally {
		   	System.out.println("Closing session");
		   	session.flush();
		session.close();
		}

		
		return userData;
		
	}

	@Override
	public void updateUser(Users p) {
		Session session = null;
    	
    	try {
	    	System.out.println("DADSDASDASDASDASDSAASDDASASDASD");
	    	session = this.sessionFactory.openSession();
	    	session.update(p);
	    	logger.info("user updated successfully");
	    } catch(Exception e){
	    	e.printStackTrace();
	    } finally {
	    	System.out.println("Closing session");
	    	session.flush();
			session.close();
		}
		
	}

	@Override
	public void addUser(Users p) {
		Session session = null;
    	
    	try{
    		session = this.sessionFactory.openSession();
    		org.hibernate.Transaction txn = null;
		    txn = session.beginTransaction();
			System.out.println("adding user==="+p.getId());
			System.out.println("adding user==="+p.getUsername());
			session.saveOrUpdate(p);
			txn.commit();
			System.out.println("jhhj user saved successfully");
		
	    } catch(Exception e){
	    	e.printStackTrace();
	    } finally {
	    	System.out.println("Closing session");
			session.close();
		}
		
	}

	@Override
	public Users getUserById(int userId) {
		Users user = null;
		Session session = null;
		

		try{
		session = this.sessionFactory.openSession();
		Query query = session
		.createQuery("from Users where id = :userId");
		query.setParameter("userId", userId);
		List userData = query.list();

		if (CollectionUtils.isNotEmpty(userData)) {
		   System.out.println("user found with is data");
		   user = (Users) userData.get(0);

		} else {
		   logger.info("no user found with user id={}", user);
		}
		   } catch(Exception e){
		   	e.printStackTrace();
		   } finally {
		   	System.out.println("Closing session");
		   	session.flush();
		session.close();
		}

		
		return user;
	}
	
}
