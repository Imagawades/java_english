package com.example.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.Folder;
import com.example.domain.user.model.Part_of_speech;
import com.example.domain.user.model.Question;
import com.example.domain.user.model.User;
import com.example.domain.user.model.Word;
import com.example.domain.user.service.UserService;
import com.example.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper mapper;
	public List<User> getLoginUser(String email,String password){
		return mapper.getLoginUser(email,password);
	}
	public void registarUser(User user) {
		mapper.registarUser(user);
	}
	public List<Folder> getFolderInfo(Integer userId){
		return mapper.getFolderInfo(userId);
	}
	public void registarWord(Word word) {
		mapper.registarWord(word);
	}
	public List<Part_of_speech> getpart_of_speech(){
		return mapper.getpart_of_speech();
	}
	public User getUser(String email) {
		return mapper.getUser(email);
	}
	public List<Word>getAllWords(Integer folderId){
		return mapper.getAllWords(folderId);
	}
	public void createQuestionTable(Question question) {
		mapper.createQuestionTable(question);
		
	}
	public List<Question> getAllQuestions(Integer userId){
		return mapper.getAllQuestions(userId);
	}
	public void updateFlag(Question question) {
		mapper.updateFlag(question);
	}
	public Word getWord(Integer wordId) {
		return mapper.getWord(wordId);
	}
}
