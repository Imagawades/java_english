package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.user.model.User;
import com.example.domain.user.service.UserService;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    
    /** ログイン画面を表示 */
    @GetMapping("/login")
    public String getLogin(Model model,User user) {
    	model.addAttribute("user",user);
        return "login/login";
    }

    /** ユーザー一覧画面にリダイレクト */
    @PostMapping("/login")
    public String postLogin(Model model,User user) {
    	String email=user.getEmail();
    	String password=user.getPassword();
    	//ログインユーザーの情報取得
    	List<User> loginUser=userService.getLoginUser(email,password);
    	if(loginUser.size()!=0) {
    		return "redirect:/user/home";
    	}
    	else {
    		return "redirect:/user/registar";
    	}
    	
        
    }
}
