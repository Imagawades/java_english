package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Answer;
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
	public String getEnglish(Model model,Answer answer,Word word) {
		Integer wordId=session.getWordId();
		Word wordAnswer=userService.getWord(wordId);
		word.setEnglish(wordAnswer.getEnglish());
		word.setJapanese(wordAnswer.getJapanese());
		answer.setWordId(wordId);
		model.addAttribute("word",word);
		model.addAttribute("answer",answer);
		return "/user/englishanswer";
	}
	@PostMapping("/english/answer")
	public String postEnglish(Model model,Answer answer) {
		//現在時刻をセット
		Date now=new Date();
		answer.setDate(now);
		System.out.println("answer");
		
		System.out.println(answer);
		//answerテーブルに回答状況を登録
		userService.registarAnswer(answer);
		
		return "/user/englishtest";
	}
	
}