package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Session;
import com.example.domain.user.model.User;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserRegistar{
	@Autowired
	UserService userService;
	@Autowired
	Session session;
	
	@GetMapping("/registar")
	public String getUserRegistar(Model model,User user) {
		model.addAttribute("user",user);
		return "user/registar";
	}
	
	@PostMapping("/registar")
	public String postUserRegistar(Model model,User user) {
		userService.registarUser(user);
		session.setEmail(user.getEmail());
		session.setPassword(user.getPassword());
		session.setUserName(user.getUserName());
		return "user/home";
	
	}
	
}