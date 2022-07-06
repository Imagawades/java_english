package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Folder;
import com.example.domain.user.model.Part_of_speech;
import com.example.domain.user.model.Word;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user/folder")
public class WordRegistarController{
	
	@Autowired
    UserService userService;

	@GetMapping("/wordregistar/{folderId:.+}")
	public String getFolderDetail(Word word,Folder folder,Model model,@PathVariable("folderId") Integer folderId) {
		word.setFolderId(folderId);
		model.addAttribute("word",word);
		
		//品詞のプルダウン表示
		List<Part_of_speech> part_of_speechs=userService.getpart_of_speech();
		System.out.println(part_of_speechs);
		model.addAttribute("part_of_speechs",part_of_speechs);
		
		
		return "user/wordregistar";
	}
	@PostMapping("/wordregistar")
	public String postFolderDetail(Word word) {
		//単語情報登録
		System.out.println(word);
		word.setFolderId(1);
		word.setUserId(1);
		userService.registarWord(word);
		return "user/wordregistar";
	}
}