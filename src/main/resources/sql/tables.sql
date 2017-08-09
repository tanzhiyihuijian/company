
DROP DATABASE IF EXISTS ssh_template;
CREATE DATABASE IF NOT EXISTS ssh_template;

USE ssh_template;

CREATE TABLE user (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(30),
  password VARCHAR(20)
);

INSERT INTO user (name, password) VALUES ('小明', '123456789');
INSERT INTO user (name, password) VALUES ('小花', '135792468');
INSERT INTO user (name, password) VALUES ('小芳', '147258369');

UPDATE user SET name = '小明' WHERE id = 1;

