DROP TABLE IF EXISTS sector CASCADE;
DROP TABLE IF EXISTS user_data;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 10000;

CREATE TABLE sector(
                     id INT PRIMARY KEY DEFAULT nextval('global_seq'),
                     parent_id INT,
                     name VARCHAR(255),

                     CONSTRAINT id_parent_id UNIQUE (id, parent_id)

);

CREATE TABLE user_data(
                        id INT PRIMARY KEY DEFAULT nextval('global_seq'),
                        name VARCHAR(255),
                        is_agree boolean,
                        sectors VARCHAR(255)
);