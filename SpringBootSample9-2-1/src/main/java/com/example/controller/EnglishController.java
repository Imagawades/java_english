package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Session;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")

public class EnglishController{
	@Autowired
	UserService userService;
	@Autowired
	Session session;
	
	@GetMapping("/english")
	public String getEnglish() {
		
		return "/user/englishstart";
	}
	
}