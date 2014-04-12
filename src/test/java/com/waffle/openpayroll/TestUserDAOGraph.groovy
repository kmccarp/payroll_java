package com.waffle.openpayroll

import static org.junit.Assert.*

import org.junit.Before;
import org.junit.BeforeClass
import org.junit.Test

import com.github.jkschneider.pappus.GraphObjectMapper;
import com.github.jkschneider.pappus.GremlinModelSteps;
import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraph
import com.tinkerpop.gremlin.groovy.Gremlin
import com.waffle.openpayroll.dao.UserDAOGraph
import com.waffle.openpayroll.domain.User

class TestUserDAOGraph {
	
	Graph g 
	UserDAOGraph dao
	GraphObjectMapper mapper
	
	@Before
	void before() {
		g = new TinkerGraph()
		mapper = new GraphObjectMapper(g)
		dao = new UserDAOGraph(g: g, mapper: mapper)
		
		assert g.V.collect{it}.size() == 0
	}
	
	@BeforeClass
	static void beforeClass() {
		Gremlin.load();
		GremlinModelSteps.load();
	}
	
	@Test
	void testSaveUser() {
		User user = new User(username: 'kwcarpenter', password: 'password')
		
		dao.saveUser(user)
		
		assert g.V.collect{it}.size() == 1
	}
	
	@Test
	void testFindAll() {
		User user = new User(username: 'joe', password: 'joespass')
		User user2 = new User(username: 'jim', password: 'jimspass')
		
		dao.saveUser(user)
		dao.saveUser(user2)
		
		assert dao.findAll().size() == 2
	}
	
	@Test
	void testFind() {
		User user = new User(username: 'steve', password: 'stevepass')
		dao.saveUser(user)
		
		assert dao.findByUsername('steve') == user
	}

}
