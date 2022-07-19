package com.example.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")

public class TodayEnglishTestStartController{
	@Autowired
	UserService userService;
	
	@GetMapping("/todayenglishteststart")
	public void getTodayEnglishTestStart() {
		//出すべき問題の取得
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.DATE, -1);
		Date date = cal.getTime();
		Date now=new Date();
		System.out.println(date);
		System.out.println(now);
		//userService.insertNowDate(date);
		//List<WordAnswerList> words=userService.getTodayWord(date);
		//System.out.println(words);
		
		
		
	}
	
}