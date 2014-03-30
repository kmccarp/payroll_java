package com.waffle.openpayroll.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waffle.openpayroll.dao.UserDAO;
import com.waffle.openpayroll.domain.User;

@RestController
public class UserController {

	@Inject
	private UserDAO dao;
	
	@RequestMapping("/op/users")
	public List<User> listAll() {
		Iterable<User> findAll = dao.findAll();
		
		List<User> userList = new ArrayList<User>();
		for(User user : findAll) {
			userList.add(user);
		}
		
		return userList;
	}
	
}
