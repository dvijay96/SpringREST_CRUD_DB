package com.sasken.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sasken.model.User;
import com.sasken.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody User user){
		
		String msg;
		try {
			service.addUser(user);
			msg="User Created";
		}catch(Exception e) {
			msg="User already exists!!!";
		}
		
		System.out.println("User Created");
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int userId) {

		service.deleteUserById(userId);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int userId) {

		if (service.getUserById(userId) == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		User user = service.getUserById(userId);
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> users = service.getAllUsers();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
