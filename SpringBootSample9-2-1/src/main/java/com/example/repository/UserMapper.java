package com.example.repository;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.user.model.Answer;
import com.example.domain.user.model.AnswerList;
import com.example.domain.user.model.Folder;
import com.example.domain.user.model.Part_of_speech;
import com.example.domain.user.model.Question;
import com.example.domain.user.model.User;
import com.example.domain.user.model.Word;
import com.example.domain.user.model.WordAnswerList;

@Mapper
public interface UserMapper {
	public List<User> getLoginUser(String email,String password);
	
	public void registarUser(User user);
	
	public List<Folder> getFolderInfo(Integer userId);
	
	public void registarWord(Word word);
	
	public List<Part_of_speech> getpart_of_speech();
	
	public User getUser(String email);
	
	public List<Word>getAllWords(Integer userId,Integer folderId);
	
	public void createQuestionTable(Question question);
	
	public List<Question> getAllQuestions(Integer userId,Integer folderId);
	
	public void updateFlag(Question question);
	
	public Word getWord(Integer wordId);
	
	public void registarAnswer(Answer answer);
	
	public List<Answer> getAnswer(Integer wordId);
	
	public void updateAnswertoQuestion(Integer wordId,Integer answerId,Integer answerSituationId); 
	
	public List<AnswerList> getAnswerList(Integer wordId,Integer userId,Integer folderId);
	
	public void deleteAnswer(Integer userId,Integer folderId);
	
	public List<WordAnswerList> getAnswerOneWord(Integer wordId);
}
