package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.Answer;
import com.example.domain.user.model.AnswerList;
import com.example.domain.user.model.Folder;
import com.example.domain.user.model.Part_of_speech;
import com.example.domain.user.model.Question;
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
	
	//品詞一覧取得
	public List<Part_of_speech> getpart_of_speech();
	
	//ユーザーIDの検索
	public User getUser(String email);
	
	//フォルダごとの単語全件取得
	public List<Word>getAllWords(Integer userId,Integer folderId);
	
	//出題テーブルの作成
	public void createQuestionTable(Question question);
	
	//出題問題の取得
	public List<Question> getAllQuestions(Integer userId,Integer folderId);
	
	//出題問題のフラグ更新
	public void updateFlag(Question question);
	
	//出題単語取得
	public Word getWord(Integer wordId);
	
	//回答状況の登録
	public void registarAnswer(Answer answer);
	
	//回答状況の取得
	public List<Answer> getAnswer(Integer wordId);
	
	//Questionテーブルへ回答状況を反映
	public void updateAnswertoQuestion(Integer wordId,Integer answerId,Integer answerSituationId); 
	
	//回答状況の取得
	public List<AnswerList> getAnswerList(Integer wordId,Integer userId,Integer folderId);
	
	//questionテーブルの該当データを削除
	public void deleteAnswer(Integer userId,Integer folderId);

}
