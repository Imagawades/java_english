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
import com.example.domain.user.model.Wordplusflag;
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
		//フラグ情報付きのモデルに移し替え
		List<Wordplusflag> words=new ArrayList<>();
		for(int i=0;i<wordList.size();i++) {
			Wordplusflag word=new Wordplusflag();
			
			word.setWordId(wordList.get(i).getWordId());
			word.setEnglish(wordList.get(i).getEnglish());
			word.setJapanese(wordList.get(i).getJapanese());
			word.setPart_of_speechName(wordList.get(i).getPart_of_speechName());
			word.setUserId(wordList.get(i).getUserId());
			word.setFolderId(wordList.get(i).getFolderId());
			word.setFlag(0);
			words.add(word);
		}
		List<WordList> wordAnswerLists=new ArrayList<>();
		
		for(int l=0;l<wordList.size();l++) {
			Integer wordId=wordList.get(l).getWordId();
			//指定されたwordIdの単語のみの回答状況を取得
			List<WordAnswerList> answers=userService.getAnswerOneWord(wordId);
			if(words.get(l).getFlag()==0) {
				System.out.println("l");
				System.out.println(l);
				System.out.println(words.get(l).getFlag());
				words.get(l).setFlag(1);		
				System.out.println(words.get(l).getFlag());
				//単語の直近3件分の正誤データを取得
				
					WordList wordLists=new WordList();
					wordLists.setWordId(wordId);
					wordLists.setEnglish(answers.get(0).getEnglish());
					wordLists.setJapanese(answers.get(0).getJapanese());
					if(answers.size()-1>-1) {
						wordLists.setDate1(answers.get(answers.size()-1).getDate());
						if(answers.get(answers.size()-1).getAnswerSituationId()==0) {
							wordLists.setAnswerSituationId1(0);
							wordLists.setAnswer1("正解");
						}
						else{
							wordLists.setAnswerSituationId1(1);
							wordLists.setAnswer1("不正解");
						}
						if(answers.size()-2>-1) {
							wordLists.setDate2(answers.get(answers.size()-2).getDate());
							if(answers.get(answers.size()-2).getAnswerSituationId()==0) {
								wordLists.setAnswerSituationId2(0);
								wordLists.setAnswer2("正解");
							}
							else{
								wordLists.setAnswerSituationId2(1);
								wordLists.setAnswer2("不正解");
							}
							if(answers.size()-3>-1) {
								wordLists.setDate3(answers.get(answers.size()-3).getDate());
								if(answers.get(answers.size()-3).getAnswerSituationId()==0) {
									wordLists.setAnswerSituationId3(0);
									wordLists.setAnswer3("正解");
								}
								else{
									wordLists.setAnswerSituationId3(1);
									wordLists.setAnswer3("不正解");
								}
							}
						}
					userService.registarWordAnswer(wordLists);	
					wordAnswerLists.add(wordLists);
				}
			}
			
		}
		
		
		System.out.println("wordAnswerLists");
		System.out.println(wordAnswerLists);
		model.addAttribute("wordAnswerLists",wordAnswerLists);
		
		
		
		return "user/wordList";
	}
	
	
}