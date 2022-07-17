package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class WordAnswerList{
	private Integer answerId;
	private Integer wordId;
	private String english;
	private String japanese;
	private Date date;
	private Integer answerSituationId;
}