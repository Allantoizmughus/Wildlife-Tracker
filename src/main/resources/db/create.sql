SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS Animals (
  id int PRIMARY KEY auto_increment,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS Endangered (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  endangered boolean,
  health VARCHAR,
  age int
);

CREATE TABLE IF NOT EXISTS Sightings (
  animal_id int PRIMARY KEY auto_increment,
  location VARCHAR,
  rangerName VARCHAR,
  id int,
  date TIMESTAMP
);


