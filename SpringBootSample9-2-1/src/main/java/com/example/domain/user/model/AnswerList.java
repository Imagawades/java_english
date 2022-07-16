package com.example.domain.user.model;

import lombok.Data;

@Data
public class AnswerList{
	Integer questionId;
	Integer answerId;
	Integer wordId;
	String english;
	String japanese;
	Integer answerSituationId;
}