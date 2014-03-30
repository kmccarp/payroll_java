package com.waffle.openpayroll.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.waffle.openpayroll.web.request.LoginRequest;
import com.waffle.openpayroll.web.request.LoginResponse;

/**
 * 
 * @author Kevin Carpenter
 * @since Mar 30, 2014
 *
 */
@RestController
public class LoginController {

	@Inject
	private AuthenticationService authService;
	
	@Inject
	private UserRetrievalService userService;

	@RequestMapping(value= "/op/isAuthenticated", method=RequestMethod.GET)
	public LoginResponse isLoggedIn(HttpServletRequest request) {
		Object attribute = request.getSession().getAttribute("isAuthenticated");
		boolean b = attribute != null;
		LoginResponse response = new LoginResponse();
		response.setAuthenticated(b);
		return response;
	}

	@RequestMapping(value = "/op/login", method = RequestMethod.POST)
	public LoginResponse login(HttpServletRequest httpRequest, @RequestBody LoginRequest request) {
		boolean authenticated = authService.isAuthenticated(request.getUsername(), request.getPassword());
		if (authenticated) {
			httpRequest.getSession().setAttribute("user", userService.findByUsername(request.getUsername()));
		}
		LoginResponse response = new LoginResponse();
		response.setAuthenticated(authenticated);
		return response;
	}

}
