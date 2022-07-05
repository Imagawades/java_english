package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.Folder;
import com.example.domain.user.model.User;
import com.example.domain.user.model.Word;

public interface UserService {
	//ログインユーザーの取得
	public List<User> getLoginUser(String email,String password);
	//新規ユーザーの登録
	public void registarUser(User user);
	
	//フォルダ情報の取得
	public List<Folder> getFolderInfo(Integer userId);
	
	//単語登録
	public void registarWord(Word word);

}
