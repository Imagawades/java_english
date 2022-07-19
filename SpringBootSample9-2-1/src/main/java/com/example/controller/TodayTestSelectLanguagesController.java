package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class TodayTestSelectLanguagesController{
	
	
	@GetMapping("/todaytestselectlanguages")
	public String getTodatTestSelectLanguages(Model model) {
		return "user/todaytestselectlanguages";
		
	}
	
}