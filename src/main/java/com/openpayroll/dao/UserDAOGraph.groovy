package com.openpayroll.dao

import javax.inject.Inject

import com.github.jkschneider.pappus.GraphObjectMapper
import com.openpayroll.domain.Employee
import com.openpayroll.domain.Manager
import com.openpayroll.domain.Role
import com.openpayroll.domain.User
import com.tinkerpop.blueprints.Graph

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

	@Override
	public void saveEmployee(Employee employee) {
		mapper.toGraph(employee)
	}

	@Override
	public void saveManager(Manager manager) {
		mapper.toGraph(manager)
	}

	@Override
	public void setUserRole(User user, Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUserRole(User user, Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		
	}

	
}
