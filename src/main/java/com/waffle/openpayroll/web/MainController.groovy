package com.waffle.openpayroll.web;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * @author Kevin
 *
 */
@Controller
public class MainController {
	
	public MainController() {
//		System.exit(1)
	}

//	@RequestMapping("/")
	@ResponseBody
	public String main(HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		def x = new File("src/main/resources/index.html").text;
		return x
	}
	
}
