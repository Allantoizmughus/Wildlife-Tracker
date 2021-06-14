SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS animals (
  id serial PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE IF NOT EXISTS endangered (
  id serial  PRIMARY KEY,
  name VARCHAR,
  endangered boolean,
  health VARCHAR,
  age int
);

CREATE TABLE IF NOT EXISTS sightings (
  animal_id serial PRIMARY KEY,
  location VARCHAR,
  rangerName VARCHAR,
  id int,
  date TIMESTAMP
);


