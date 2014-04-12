package com.waffle.openpayroll.dao;

import com.waffle.openpayroll.domain.User;

public interface UserSearchDAO {
	public Iterable<User> findAll();
	
	public User findByUsername(String username);
}