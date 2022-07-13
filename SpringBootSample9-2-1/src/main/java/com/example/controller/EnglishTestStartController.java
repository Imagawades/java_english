package com.example.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Question;
import com.example.domain.user.model.Session;
import com.example.domain.user.model.Word;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")

public class EnglishTestStartController{
	@Autowired
	UserService userService;
	@Autowired
	Session session;
	
	@GetMapping("/englishteststart")
	public String getEnglishTest() {
		Integer folderId=session.getFolderId();
		//フォルダ内の全単語取得
		List<Word> words=userService.getAllWords(folderId);
		Collections.shuffle(words);
		for(int i=0;i<words.size();i++) {
			Question question=new Question();
			question.setWordId(words.get(i).getWordId());
			question.setUserId(words.get(i).getUserId());
			question.setFlag(0);
			System.out.println(question);
			//出題問題をテーブルに登録
			userService.createQuestionTable(question);
			
		}
		return "/user/englishteststart";
	}
	
}