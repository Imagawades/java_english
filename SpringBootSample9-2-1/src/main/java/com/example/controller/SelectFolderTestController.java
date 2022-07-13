package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Folder;
import com.example.domain.user.model.Session;
import com.example.domain.user.model.User;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class SelectFolderTestController{
	@Autowired
	UserService userService;
	@Autowired
	Session session;
	@GetMapping("/selectfoldertest")
	public String getSelectFolderTest(Model model) {
		//フォルダ情報取得
		String email=session.getEmail();
		User user=userService.getUser(email);
		Integer userId=user.getUserId();
		
		List<Folder> folderList=userService.getFolderInfo(userId);
		model.addAttribute("folderList",folderList);
		return "user/selectfoldertest";
		
	}
	
	
}