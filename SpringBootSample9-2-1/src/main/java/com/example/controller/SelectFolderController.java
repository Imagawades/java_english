package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Folder;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class SelectFolderController{
	@Autowired
	UserService userService;
	@GetMapping("/selectfolder")
	public String getSelectFolder(Model model) {
		//フォルダ情報取得
		Integer userId=1;
		List<Folder> folderList=userService.getFolderInfo(userId);
		model.addAttribute("folderList",folderList);
		return "user/selectfolder";
		
	}
	
	
}