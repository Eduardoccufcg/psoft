package com.example.demo.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.rest.dao.UserDAO;
import com.example.demo.rest.model.User;

@Service
public class UserService {

	private final UserDAO userDAO;

	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User create(User user) throws UserExistsException {
		User u = this.userDAO.findByLogin(user.getLogin());

		if (u != null) {

			throw new UserExistsException("Esse usúario já existe!");
		}

		return userDAO.save(user);
	}

	public User findByLogin(String login) {
		return this.userDAO.findByLogin(login);
	}

	public List<User> findAll() {
		return this.userDAO.findAll();
	}

}
