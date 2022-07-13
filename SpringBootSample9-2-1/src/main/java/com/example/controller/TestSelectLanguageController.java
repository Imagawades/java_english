package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.Folder;
import com.example.domain.user.model.Session;
import com.example.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class TestSelectLanguageController{
	@Autowired
	UserService userService;
	@Autowired
	Session session;
	@GetMapping("/test/selectlanguage/{folderId:.+}")
	public String getSelectFolderTest(Model model,Folder folder,@PathVariable("folderId") Integer folderId) {
		folder.setFolderId(folderId);
		session.setFolderId(folderId);
		model.addAttribute("folder",folder);
		
		return "user/testselectlanguage";
		
	}
	
	
}