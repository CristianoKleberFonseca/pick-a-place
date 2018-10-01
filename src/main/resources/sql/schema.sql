CREATE TABLE IF NOT EXISTS restaurant (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(500)
)ENGINE = innodb;

CREATE TABLE IF NOT EXISTS employee (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(500) NOT NULL
)ENGINE = innodb;

CREATE TABLE IF NOT EXISTS user (
  id NOT NULL INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL PRIMARY KEY,
  email VARCHAR(50),
  password VARCHAR(500),
  activated BOOLEAN DEFAULT FALSE
)ENGINE = innodb;

CREATE TABLE IF NOT EXISTS favorites (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  id_employee INT NOT NULL,
  CONSTRAINT fk_employee_favorites FOREIGN KEY (id_employee) REFERENCES employee (id))ENGINE = innodb;

CREATE TABLE IF NOT EXISTS favorites_items (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  id_restaurant INT NOT NULL,
  id_favorites INT NOT NULL,
  CONSTRAINT fk_restaurant_favorites_items FOREIGN KEY (id_restaurant) REFERENCES restaurant (id),
  CONSTRAINT fk_favorites_favorites_items FOREIGN KEY (id_favorites) REFERENCES favorites (id))ENGINE = innodb;
  
CREATE TABLE IF NOT EXISTS vote ()ENGINE = innodb;