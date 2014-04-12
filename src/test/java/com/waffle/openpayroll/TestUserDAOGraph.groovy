package com.waffle.openpayroll

import static org.junit.Assert.*

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

import com.github.jkschneider.pappus.GraphObjectMapper
import com.github.jkschneider.pappus.GremlinModelSteps
import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraph
import com.tinkerpop.gremlin.groovy.Gremlin
import com.waffle.openpayroll.dao.UserDAOGraph
import com.waffle.openpayroll.domain.Employee
import com.waffle.openpayroll.domain.Manager
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
	
	@Test
	void testSaveEmployee() {
		User user = new User(username: 'kemployee', password: 'stuff')
		Employee employee = new Employee(name: 'Katt Stevens', salaried: true, user: user)
		
		dao.saveUser(user)
		dao.saveEmployee(employee)
		
		g.vertices.each {println it.map()}
		
		assert g.V.count() == 2
		assert g.E.count() == 1  
	}
	
	@Test
	void testSaveManager() {
		User user = new User(username: 'jmanager', password: 'stuff')
		Manager employee = new Manager(name: 'Joe Short', user: user)
		
		dao.saveUser(user)
		dao.saveManager(employee)
		
		assert g.V.count() == 2
		assert g.E.count() == 1
	}

}
