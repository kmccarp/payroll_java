package com.openpayroll.dao;

import com.openpayroll.domain.User;

public interface UserSearchDAO {
	public Iterable<User> findAll();
	
	public User findByUsername(String username);
}