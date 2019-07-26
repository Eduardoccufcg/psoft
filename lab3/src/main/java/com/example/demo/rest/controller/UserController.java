package com.example.demo.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rest.exceptions.UserNotFoundException;
import com.example.demo.rest.model.User;
import com.example.demo.rest.service.UserExistsException;
import com.example.demo.rest.service.UserService;

@RestController
@RequestMapping({"/v1/users"})
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/{login}")
	public ResponseEntity<User> getUser(@PathVariable String login) throws UserNotFoundException {
		User user = this.userService.findByLogin(login);
		
		if (user == null) {
			throw new UserNotFoundException("Usuário não existe!");
		}
		
		return new ResponseEntity<User>( this.userService.findByLogin(login), HttpStatus.OK);
	}
	
	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<User> create(@RequestBody User user) throws UserExistsException {
		return new ResponseEntity<User>( this.userService.create(user), HttpStatus.CREATED );
	}
}