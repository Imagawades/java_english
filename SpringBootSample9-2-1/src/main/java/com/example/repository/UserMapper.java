package com.example.repository;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.user.model.Folder;
import com.example.domain.user.model.User;
import com.example.domain.user.model.Word;

@Mapper
public interface UserMapper {
	public List<User> getLoginUser(String email,String password);
	
	public void registarUser(User user);
	
	public List<Folder> getFolderInfo(Integer userId);
	
	public void registarWord(Word word);

}
