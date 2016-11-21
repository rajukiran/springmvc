package com.acknotech.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.acknotech.core.dao.UsersDao;
import com.acknotech.core.dto.users.Users;
import com.acknotech.core.model.UsersVO;


public class UserServiceImpl implements UserService{
	
	@Autowired
	private UsersDao userDao;
	
	
	public void setUserDao(UsersDao userDao) {
		this.userDao = userDao;
	}
	

	@Override
	public List<UsersVO> findAllUsers() {
		List<Users> user =  this.userDao.getAllUsers();
		UsersVO userTO = null;
		List<UsersVO> user2 = new ArrayList<UsersVO>();
		for(Users users : user){
			
			if (null != users) {
				userTO = new UsersVO();
				userTO.setId(users.getId());
				userTO.setUsername(users.getUsername());
				userTO.setPassword(users.getPassword());
				System.out.println(userTO.getId());
			}
			user2.add((UsersVO)userTO);
		}
		return user2;
	}


	@Transactional
    public void addUser(Users p) {
    	try{
    		System.out.println("adding user");
    		this.userDao.addUser(p);
    	} catch(Exception e){
    		e.printStackTrace();
    	}
    }


	@Override
	public void updateUser(Users p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public UsersVO getUserById(int userId) {
		Users user =  this.userDao.getUserById(userId);
		UsersVO userTO = null;
		
		
			if (null != user) {
				userTO = new UsersVO();
				userTO.setId(user.getId());
				userTO.setUsername(user.getUsername());
				userTO.setPassword(user.getPassword());
				System.out.println(userTO.getId());
			}
			
		
		return userTO;
	}

}
