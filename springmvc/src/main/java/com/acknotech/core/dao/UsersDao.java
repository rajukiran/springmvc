package com.acknotech.core.dao;

import com.acknotech.core.dto.users.Users;
import java.util.List;

public interface UsersDao {
	public List<Users> getAllUsers();
//	public abstract List<Users> getAllUsers(String userName);
}
