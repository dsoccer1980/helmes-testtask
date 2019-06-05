DROP TABLE IF EXISTS sector CASCADE;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 10000;

CREATE TABLE sector(
  id INT PRIMARY KEY DEFAULT nextval('global_seq'),
  parent_id INT,
  name VARCHAR(255),

  CONSTRAINT id_parent_id UNIQUE (id, parent_id)

);