SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS Animals (
  id int PRIMARY KEY auto_increment,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS Endangered (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  endangered boolean,
  health VARCHAR
  age int
);