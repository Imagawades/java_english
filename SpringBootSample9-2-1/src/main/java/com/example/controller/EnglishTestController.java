package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Question;
import com.example.domain.user.model.Session;
import com.example.domain.user.model.User;
import com.example.domain.user.model.Word;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")

public class EnglishTestController{
	@Autowired
	UserService userService;
	@Autowired
	Session session;
	
	@GetMapping("/englishtest")
	public String getEnglishTest(Model model,Word word) {
		//出題問題取得
		String email=session.getEmail();
		Integer folderId=session.getFolderId();
		//ログインユーザーのユーザーId取得
		User user=userService.getUser(email);
		Integer userId=user.getUserId();
		
		//出題予定の問題を取得
		List<Question> questions=userService.getAllQuestions(userId,folderId);
		
		for(int i=0;i<questions.size();i++) {
			
			if(questions.get(i).getFlag()==0) {
				System.out.println(i);
				
				Question question=new Question();
				System.out.println(question);
				question.setQuestionId(questions.get(i).getQuestionId());
				question.setWordId(questions.get(i).getWordId());
				question.setUserId(questions.get(i).getUserId());
				question.setFolderId(questions.get(i).getFolderId());
				question.setFlag(1);
				
				//出題した問題のflag更新
				userService.updateFlag(question);
				
				Integer wordId=questions.get(i).getWordId();
				
				//出題する単語
				Word oneWord=userService.getWord(wordId);
				session.setWordId(question.getWordId());
				model.addAttribute("word",oneWord);
				break;
			}
			
			
		}
		
		
		return "user/englishtest";
	}
	
}