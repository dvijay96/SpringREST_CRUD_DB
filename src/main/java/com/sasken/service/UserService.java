package com.sasken.service;

import java.util.List;

import com.sasken.model.User;

public interface UserService {

	public void addUser(User user)throws Exception;

	public void deleteUserById(int id);

	public User getUserById(int id);

	public List<User> getAllUsers();

}
