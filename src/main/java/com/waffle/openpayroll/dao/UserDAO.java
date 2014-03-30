package com.waffle.openpayroll.dao;

import org.springframework.data.repository.CrudRepository;

import com.waffle.openpayroll.domain.User;

public interface UserDAO extends CrudRepository<User, Long>{
	@Override
	public Iterable<User> findAll();
}