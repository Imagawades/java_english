INSERT INTO user (userId,userName,email,password)
VALUES(1,'1', 'iy0827@icloud.com', 'acvGqF5c');

INSERT INTO folder (folderId,folderName,userId,completeRate)
VALUES(1,'A',1,40),(2,'B',1,50),(3,'CCCC',1,50)
;

INSERT INTO word(wordId,english,japanese,part_of_speechName,folderId,userId)
VALUES(1,'apple','りんご','名詞',1,1);

INSERT INTO part_of_speech(part_of_speechId,part_of_speechName)
VALUES(1,'動詞'),(2,'名詞'),(3,'形容詞'),(4,'副詞'),(5,'冠詞'),(6,'代名詞'),(7,'前置詞'),(8,'接続詞');