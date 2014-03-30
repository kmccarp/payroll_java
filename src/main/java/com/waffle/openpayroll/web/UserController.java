package com.waffle.openpayroll.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waffle.openpayroll.domain.User;

@RestController
public class UserController {

	@Inject
	private UserRetrievalService service;
	
	@RequestMapping("/op/users")
	public List<User> listAll() {
		return service.findAll();
	}
	
}
