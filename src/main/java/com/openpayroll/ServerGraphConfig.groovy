package com.openpayroll

import javax.annotation.PostConstruct
import javax.inject.Inject

import org.springframework.stereotype.Component

import com.tinkerpop.blueprints.Graph
import com.waffle.openpayroll.dao.UserSaveDAO
import com.waffle.openpayroll.domain.User

@Component
class ServerGraphConfig {

	@Inject
	public Graph g
	@Inject
	public UserSaveDAO userDao
	
	@PostConstruct
	void postConstruct() {
		g.V.each {println it.map()}
		
		// setup graph with test data
		if (g.V.count() == 0) {
			User employee = new User(username: 'kwcarpenter', password: 'password')
			User manager = new User(username: 'jmanager', password: 'password')
			User admin = new User(username: 'sadmin', password: 'password')
			userDao.saveUser(employee)
			userDao.saveUser(manager)
			userDao.saveUser(admin)
		}
	}
}
