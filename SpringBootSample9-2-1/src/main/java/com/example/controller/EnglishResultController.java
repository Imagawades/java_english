package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.AnswerList;
import com.example.domain.user.model.AnswerResult;
import com.example.domain.user.model.Session;
import com.example.domain.user.model.User;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class EnglishResultController{
	@Autowired
	UserService userService;
	@Autowired
	Session session;
	
	@GetMapping("/englishresult")
	public String getEnglishResult(Model model,AnswerResult answerResult) {
		//questionテーブルから回答状況取得
		Integer wordId=session.getWordId();
		Integer folderId=session.getFolderId();
		String email=session.getEmail();
		User user=userService.getUser(email);
		Integer userId=user.getUserId();
		//questionテーブルからテスト結果を取得
		List<AnswerList> answerLists=userService.getAnswerList(wordId,userId,folderId);
		List<AnswerResult> answerresult=new ArrayList<>();
		float counter =0;
		for(int i=0;i<answerLists.size();i++) {
			AnswerResult answer=new AnswerResult();
			answer.setWordId(answerLists.get(i).getWordId());
			answer.setEnglish(answerLists.get(i).getEnglish());
			answer.setJapanese(answerLists.get(i).getJapanese());
			if(answerLists.get(i).getAnswerSituationId()==0) {
				answer.setResult("正解");
				answerresult.add(answer);
				counter=counter+1;
				System.out.println("counter");
				System.out.println(counter);
			}
			else {
				answer.setResult("不正解");
				answerresult.add(answer);
			}
			
		}
		System.out.println("counters");
		System.out.println(counter);
		System.out.println("answer");
		System.out.println(answerLists.size());
		Integer completeRate=(int) ((counter/answerLists.size())*100);
		completeRate.toString();
		String completeRates=completeRate+"%";
		System.out.println("complete");
		System.out.println(completeRate);
		model.addAttribute("completeRate",completeRates);
		System.out.println("answerLists");
		System.out.println(answerresult);
		model.addAttribute("answerresult",answerresult);
		
		//questionテーブルから該当する回答を削除
		//userService.deleteAnswer(userId,folderId);
		
		return "user/englishresult";
		
	}
	
}