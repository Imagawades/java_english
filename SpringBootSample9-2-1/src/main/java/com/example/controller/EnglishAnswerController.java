package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Session;
import com.example.domain.user.model.Word;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")

public class EnglishAnswerController{
	@Autowired
	UserService userService;
	@Autowired
	Session session;
	
	@GetMapping("/english/answer")
	public String getEnglish(Model model,Word word) {
		Integer wordId=session.getWordId();
		Word wordAnswer=userService.getWord(wordId);
		word.setEnglish(wordAnswer.getEnglish());
		word.setJapanese(wordAnswer.getJapanese());
		model.addAttribute("word",wordAnswer);
		
		
		
		return "/user/englishanswer";
	}
	
}