package com.example.repository;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.user.model.Folder;
import com.example.domain.user.model.Part_of_speech;
import com.example.domain.user.model.Question;
import com.example.domain.user.model.User;
import com.example.domain.user.model.Word;

@Mapper
public interface UserMapper {
	public List<User> getLoginUser(String email,String password);
	
	public void registarUser(User user);
	
	public List<Folder> getFolderInfo(Integer userId);
	
	public void registarWord(Word word);
	
	public List<Part_of_speech> getpart_of_speech();
	
	public User getUser(String email);
	
	public List<Word>getAllWords(Integer folderId);
	
	public void createQuestionTable(Question question);
	
	public List<Question> getAllQuestions(Integer userId);
	
	public void updateFlag(Question question);
	
	public Word getWord(Integer wordId);

}
