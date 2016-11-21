package com.acknotech.core.services;

import java.util.*;

import com.acknotech.core.dto.users.Users;
import com.acknotech.core.model.UsersVO;

public interface UserService {
	public List<UsersVO> findAllUsers();

	public void addUser(Users p);

	public void updateUser(Users p);

	public UsersVO getUserById(int userId);

}
