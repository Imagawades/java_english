package com.example.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		Map<Integer, String> radio=new LinkedHashMap<>();
		radio.put(0,"完璧");
		radio.put(1,"まだまだ");
		model.addAttribute("radio",radio);
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
		Integer wordId =session .getWordId();
		answer.setWordId(wordId);
		//answerテーブルに回答状況を登録
		userService.registarAnswer(answer);
		//answerテーブルの情報取得
		List<Answer> answerList=userService.getAnswer(wordId);
		//questionテーブルにansweIdとanswerSituationIdをセット
		Integer answerSize=answerList.size();
		Integer answerId=answerList.get(answerSize-1).getAnswerId();
		Integer answerSituationId=answerList.get(answerSize-1).getAnswerSituationId();
		userService.updateAnswertoQuestion(wordId,answerId,answerSituationId);
		
		return "redirect:/user/englishtest";
	}
	
}