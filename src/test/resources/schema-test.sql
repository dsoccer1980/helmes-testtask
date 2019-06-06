DROP TABLE  IF EXISTS sector;
DROP TABLE IF EXISTS user_data;


CREATE TABLE sector(
  id INT PRIMARY KEY AUTO_INCREMENT,
  parent_id INT,
  name VARCHAR(255),

  CONSTRAINT id_parent_id UNIQUE (id, parent_id)

);

CREATE TABLE user_data(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  is_agree boolean,
  sectors VARCHAR(255)
);


