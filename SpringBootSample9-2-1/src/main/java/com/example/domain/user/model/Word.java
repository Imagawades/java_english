package com.example.domain.user.model;

import lombok.Data;


@Data
public class Word{
	private Integer wordId;
	private String english;
	private String japanese;
	private String part_of_speechName;
	private Integer folderId;
	private Integer userId;
}