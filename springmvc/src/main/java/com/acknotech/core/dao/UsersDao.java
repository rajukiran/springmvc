package com.acknotech.core.dao;

import com.acknotech.core.dto.users.Users;


import java.util.List;

public interface UsersDao {
	public List<Users> getAllUsers();
	public void updateUser(Users p);
	public void addUser(Users p);
	public Users getUserById(int userId);

}
