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