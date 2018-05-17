CREATE SCHEMA railway_storage;

DROP TABLE railway_storage.role;

CREATE TABLE railway_storage.role (
  id   SERIAL PRIMARY KEY,
  name CHARACTER VARYING(64) NOT NULL UNIQUE
);

INSERT INTO railway_storage.role (name) VALUES (
  'user'
);

DROP TABLE railway_storage."user";

CREATE TABLE railway_storage."user" (
  id       BIGSERIAL PRIMARY KEY,
  role_id  INTEGER REFERENCES railway_storage.role (id),
  name     CHARACTER VARYING(64) NOT NULL UNIQUE,
  password CHARACTER VARYING(64) NOT NULL,
  mailbox  CHARACTER VARYING(64) NOT NULL
);

INSERT INTO railway_storage."user" (name, role_id, password, mailbox)
VALUES
  ('Антон', (SELECT id
             FROM railway_storage.role
             WHERE name = 'user'), 'password', 'user@mail.ru');


CREATE TABLE railway_storage.station (
  id   BIGSERIAL PRIMARY KEY,
  name CHARACTER VARYING(128) NOT NULL UNIQUE
);

DROP TABLE railway_storage.type_wagon;

CREATE TABLE railway_storage.type_wagon (
  id   SERIAL PRIMARY KEY,
  type CHARACTER VARYING NOT NULL UNIQUE
);

DROP TABLE railway_storage.type_place;

CREATE TABLE railway_storage.type_place (
  id   SERIAL PRIMARY KEY,
  type CHARACTER VARYING(128) NOT NULL UNIQUE
);

DROP TABLE railway_storage.time_table;

CREATE TABLE railway_storage.time_table (
  id                BIGSERIAL PRIMARY KEY,
  station_start_id  BIGINT    NOT NULL REFERENCES railway_storage.station (id),
  station_finish_id BIGINT    NOT NULL REFERENCES railway_storage.station (id),
  train_id          BIGINT    NOT NULL  REFERENCES railway_storage.train (id),
  time_start        TIMESTAMP NOT NULL,
  time_finish       TIMESTAMP NOT NULL
);

DROP TABLE railway_storage.train;

CREATE TABLE railway_storage.train (
  id     BIGSERIAL PRIMARY KEY,
  number INTEGER                NOT NULL UNIQUE,
  name   CHARACTER VARYING(128) NOT NULL
);

DROP TABLE railway_storage.wagon;

CREATE TABLE railway_storage.wagon (
  id            BIGSERIAL PRIMARY KEY,
  number        INTEGER NOT NULL,
  train_id      BIGINT  NOT NULL REFERENCES railway_storage.train (id),
  type_wagon_id BIGINT REFERENCES railway_storage.type_wagon (id)
);

DROP TABLE railway_storage.place;

CREATE TABLE railway_storage.place (
  id            BIGSERIAL PRIMARY KEY,
  wagon_id      BIGINT  NOT NULL REFERENCES railway_storage.wagon (id),
  number        INTEGER NOT NULL,
  type_place_id BIGINT REFERENCES railway_storage.type_place (id),
  reserved      BOOLEAN DEFAULT FALSE,
  cost          NUMERIC NOT NULL
);

DROP TABLE railway_storage.booking;

CREATE TABLE railway_storage.booking (
  id         BIGSERIAL PRIMARY KEY,
  user_id    BIGINT                 NOT NULL REFERENCES railway_storage."user" (id),
  surname    CHARACTER VARYING(256) NOT NULL,
  name       CHARACTER VARYING(256) NOT NULL,
  patronymic CHARACTER VARYING(256) NOT NULL,
  passport   CHARACTER VARYING(64)  NOT NULL,
  place_id   BIGINT                 NOT NULL UNIQUE REFERENCES railway_storage.place (id)
);
