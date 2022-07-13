package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class Answer{
	private Integer answerId;
	private Integer wordId;
	private Integer answerSituationId;
	private Date date;
}