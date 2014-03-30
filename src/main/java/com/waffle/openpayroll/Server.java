package com.waffle.openpayroll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@ComponentScan(basePackages="com.waffle")
@Controller
public class Server {

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

}