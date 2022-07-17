package com.example.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.Answer;
import com.example.domain.user.model.AnswerList;
import com.example.domain.user.model.Folder;
import com.example.domain.user.model.Part_of_speech;
import com.example.domain.user.model.Question;
import com.example.domain.user.model.User;
import com.example.domain.user.model.Word;
import com.example.domain.user.model.WordAnswerList;
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
	public List<Word>getAllWords(Integer userId,Integer folderId){
		return mapper.getAllWords(userId,folderId);
	}
	public void createQuestionTable(Question question) {
		mapper.createQuestionTable(question);
		
	}
	public List<Question> getAllQuestions(Integer userId,Integer folderId){
		return mapper.getAllQuestions(userId,folderId);
	}
	public void updateFlag(Question question) {
		mapper.updateFlag(question);
	}
	public Word getWord(Integer wordId) {
		return mapper.getWord(wordId);
	}
	public void registarAnswer(Answer answer) {
		mapper.registarAnswer(answer);
	}
	public List<Answer> getAnswer(Integer wordId){
		return mapper.getAnswer(wordId);
	}
	public void updateAnswertoQuestion(Integer wordId,Integer answerId,Integer answerSituationId) {
		mapper.updateAnswertoQuestion(wordId,answerId,answerSituationId);
	}
	public List<AnswerList> getAnswerList(Integer wordId,Integer userId,Integer folderId){
		return mapper.getAnswerList(wordId,userId,folderId);
	}
	public void deleteAnswer(Integer userId,Integer folderId) {
		 mapper.deleteAnswer(userId,folderId);
	}
	public List<WordAnswerList> getAnswerOneWord(Integer wordId){
		return mapper.getAnswerOneWord(wordId);
	}
}
