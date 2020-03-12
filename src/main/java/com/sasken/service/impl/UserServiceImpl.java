package com.sasken.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasken.dao.UserDao;
import com.sasken.model.User;
import com.sasken.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	public void addUser(User user)throws Exception {

		dao.addUser(user);
	}

	public void deleteUserById(int id) {

		dao.deleteUserById(id);
	}

	public User getUserById(int id) {

		return dao.getUserById(id);
	}

	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

}
