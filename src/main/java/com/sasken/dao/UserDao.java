package com.sasken.dao;

import java.util.List;

import com.sasken.model.User;

public interface UserDao {

	public void addUser(User user)throws Exception;

	public void deleteUserById(int id);

	public User getUserById(int id);

	public List<User> getAllUsers();
	
}
