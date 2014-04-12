package com.openpayroll;
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import com.github.jkschneider.pappus.GraphObjectMapper
import com.github.jkschneider.pappus.GremlinModelSteps
import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.neo4j2.Neo4j2Graph
import com.tinkerpop.gremlin.groovy.Gremlin
import com.waffle.openpayroll.dao.UserDAO
import com.waffle.openpayroll.dao.UserDAOGraph

@EnableAutoConfiguration
@ComponentScan(basePackages="com.waffle")
@Controller
public class Server {

	private Graph g;
	private UserDAO userDao;
	GraphObjectMapper mapper
	
	@RequestMapping("/op")
	@ResponseBody
	public String op() {
		return "Hi";
	}
	
    public static void main(String[] args) throws Exception {
    	SpringApplication app = new SpringApplication(Server.class);
    	app.setShowBanner(false);
    	app.run(args);
    }
	
	@Bean
	public UserDAO userDAO() {
		userDao = new UserDAOGraph(g: g, mapper: mapper)
		return userDao
	}
	
    @Bean
    public Graph graph() {
    	Gremlin.load();
    	GremlinModelSteps.load();
    	g = new Neo4j2Graph("OpenPayroll");
		return g
    }
    
    @Bean
    public GraphObjectMapper graphObjectMapper() {
		mapper = new GraphObjectMapper(g);
		return mapper
    }

}