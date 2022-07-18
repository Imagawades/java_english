package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class WordList{
	private Integer wordId;
	private String english;
	private String japanese;
	private Date date1;
	private Integer answerSituationId1;
	private String answer1;
	private Date date2;
	private Integer answerSituationId2;
	private String answer2;
	private Date date3;
	private Integer answerSituationId3;
	private String answer3;
}