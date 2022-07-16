package com.example.domain.user.model;

import lombok.Data;

@Data
public class AnswerResult{
	Integer wordId;
	String english;
	String japanese;
	String result;
}