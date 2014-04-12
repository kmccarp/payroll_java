package com.waffle.openpayroll.dao

import javax.inject.Inject

import org.springframework.stereotype.Repository

import com.github.jkschneider.pappus.GraphObjectMapper;
import com.tinkerpop.blueprints.Graph
import com.waffle.openpayroll.domain.User

//@Repository
class UserDAOGraph implements UserDAO {
	
	@Inject
	Graph g;
	
	@Inject
	GraphObjectMapper mapper;

	@Override
	public Collection<User> findAll() {
		return g.V.model(User.class).collect{mapper.fromGraph(it, User.class)}
	}
	
	@Override
	public User findByUsername(String username) {
		def iter = g.V('username', username).model(User.class)
		
		return iter.hasNext() ? mapper.fromGraph(iter.next(), User.class) : null
	}

	@Override
	public void saveUser(User user) {
		mapper.toGraph(user)
	}

	
}
