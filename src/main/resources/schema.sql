DROP TABLE IF EXISTS APPUSER;
  
CREATE TABLE APPUSER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
 password VARCHAR(250) NOT NULL,
 useremail VARCHAR(250) NOT NULL,
 userfirstname VARCHAR(250) NOT NULL,
 userlastname VARCHAR(250) NOT NULL,
 useraddress VARCHAR(250) NOT NULL
);
