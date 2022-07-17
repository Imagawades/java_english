package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Session;
import com.example.domain.user.model.User;
import com.example.domain.user.model.Word;
import com.example.domain.user.model.WordAnswerList;
import com.example.domain.user.model.WordList;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class WordListController{
	
	@Autowired
	UserService userService;
	@Autowired
	Session session;
	
	@GetMapping("/wordList/{folderId:.+}")
	public String getWordList(Model model) {
		String email=session.getEmail();
		User user=userService.getUser(email);
		Integer userId=user.getUserId();
		Integer folderId=session.getFolderId();
		//全件単語情報取得
		List<Word> wordList=userService.getAllWords(userId,folderId);
		List<WordList> wordAnswerLists=new ArrayList<>();
		//単語の直近3件分の正誤データを取得
		for(int i=0;i<wordList.size();i++) {
			Integer wordId=wordList.get(i).getWordId();
			//指定されたwordIdの単語のみの回答状況を取得
			List<WordAnswerList> answers=userService.getAnswerOneWord(wordId);
			System.out.println("answers");
			System.out.println(answers);
			WordList wordLists=new WordList();
			System.out.println(1);
			wordLists.setWordId(wordId);
			System.out.println(2);
			System.out.println(answers);
			System.out.println(answers.get(0));
			System.out.println(i);
			System.out.println(answers.get(i).getEnglish());
			System.out.println(wordLists.getEnglish());
			wordLists.setEnglish(answers.get(i).getEnglish());
			System.out.println(3);
			wordLists.setJapanese(answers.get(i).getJapanese());
			System.out.println(4);
			System.out.println("answersize");
			System.out.println(answers.size());
			wordLists.setDate1(answers.get(answers.size()-1).getDate());
			System.out.println(5);
			wordLists.setAnswerSituationId1(answers.get(answers.size()-1).getAnswerSituationId());
			wordAnswerLists.add(wordLists);
		}
		System.out.println("wordAnswerLists");
		System.out.println(wordAnswerLists);
		model.addAttribute("wordAnswerLists",wordAnswerLists);
		
		
		
		return "user/wordList";
	}
	
	
}