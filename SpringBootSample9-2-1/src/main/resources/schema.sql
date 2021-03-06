CREATE TABLE IF NOT EXISTS user (
  userId INT AUTO_INCREMENT PRIMARY KEY,
  userName VARCHAR(50),
  email VARCHAR(50),
  password VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS folder (
  folderId INT AUTO_INCREMENT PRIMARY KEY,
  folderName VARCHAR(50),
  userId INT,
  completerate INT
);
CREATE TABLE IF NOT EXISTS word (
    wordId INT AUTO_INCREMENT PRIMARY KEY,
	english VARCHAR(50),
	japanese VARCHAR(50),
	part_of_speechName VARCHAR(50),
	folderId INT,
	userId INT
	);
CREATE TABLE IF NOT EXISTS part_of_speech (
  part_of_speechId INT AUTO_INCREMENT PRIMARY KEY,
  part_of_speechName VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS questions (
  questionId INT AUTO_INCREMENT PRIMARY KEY,
  answerId INT,
  wordId INT,
  userId INT,
  folderId INT,
  answerSituationId INT,
  flag INT
);

CREATE TABLE IF NOT EXISTS answer (
  answerId INT AUTO_INCREMENT PRIMARY KEY,
  wordId INT,
  answerSituationId INT,
  date DATE
);
CREATE TABLE IF NOT EXISTS WordList(
	wordId INT,
	english VARCHAR(50),
	japanese VARCHAR(50),
	date1 DATE,
	answerSituationId1 INT,
	date2 DATE,
	answerSituationId2 INT,
	date3 DATE,
	answerSituationId3 INT
);



