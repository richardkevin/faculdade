CREATE TABLE users (
  user_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(10) NOT NULL,
  age INT NOT NULL,
  address VARCHAR(10) NOT NULL,
  max_guests INT NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE INDEX (username)
) ENGINE=INNODB;
