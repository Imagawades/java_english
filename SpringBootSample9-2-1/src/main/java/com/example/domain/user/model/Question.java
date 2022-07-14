package com.example.domain.user.model;

import lombok.Data;

@Data
public class Question{
	private Integer questionId;
	private Integer wordId;
	private Integer userId;
	private Integer folderId;
	private Integer flag;
}