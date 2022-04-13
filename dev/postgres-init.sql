CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE ROLE petowner WITH
    LOGIN
    SUPERUSER
    INHERIT
    CREATEDB
    CREATEROLE
    REPLICATION
    PASSWORD 'petowner';


CREATE SCHEMA petowner
    AUTHORIZATION petowner;

SET SCHEMA 'petowner';

DROP TABLE IF EXISTS visits;
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS owners;

CREATE TABLE owners (
                        id serial,
                        public_identifier uuid,
                        first_name character varying(30),
                        last_name character varying(30),
                        address character varying(255),
                        city character varying(80),
                        telephone character varying(20),
                        creation_datetime timestamp,
                        update_datetime timestamp,
                        CONSTRAINT pk_owners PRIMARY KEY (id)
);
CREATE INDEX idx_owners_last_name ON owners (last_name);

CREATE TABLE pets (
                      id serial,
                      public_identifier uuid,
                      name character varying(30),
                      birth_date date,
                      type_id integer NOT NULL,
                      owner_id integer NOT NULL,
                      creation_datetime timestamp,
                      update_datetime timestamp,
                      FOREIGN KEY (type_id) REFERENCES types (id),
                      FOREIGN KEY (owner_id) REFERENCES owners (id),
                      CONSTRAINT pk_pets PRIMARY KEY (id)
);
CREATE INDEX idx_pets_name ON pets (name);

CREATE TABLE visits (
                        id serial,
                        public_identifier uuid,
                        pet_id integer NOT NULL,
                        visit_date date,
                        description character varying(255),
                        creation_datetime timestamp,
                        update_datetime timestamp,
                        FOREIGN KEY (pet_id) REFERENCES pets (id),
                        CONSTRAINT pk_visits PRIMARY KEY (id)
);
CREATE INDEX visits_pet_id ON visits (pet_id);