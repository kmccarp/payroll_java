package com.openpayroll.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.openpayroll.dao.UserDAO;
import com.openpayroll.domain.User;

@Service
public class UserServiceImpl implements AuthenticationService, UserRetrievalService {

	@Inject
	private UserDAO userDao;

	@Override
	public boolean isAuthenticated(String username, String password) {
		User user = userDao.findByUsername(username);
		if (user == null)  return false;
		return user.getPassword().equals(password);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.waffle.openpayroll.web.UserService#findAll()
	 */
	@Override
	public List<User> findAll() {
		Iterable<User> findAll = userDao.findAll();

		List<User> userList = new ArrayList<User>();
		for (User user : findAll) {
			userList.add(user);
		}

		return userList;
	}
	
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
