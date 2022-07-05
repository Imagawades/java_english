package com.example.domain.user.model;

import lombok.Data;

@Data
public class Folder{
	private Integer folderId;
	private String folderName;
	private Integer userId;
	private Integer completeRate;
}