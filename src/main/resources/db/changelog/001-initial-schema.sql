--liquibase formatted sql

--changeset Liz:1 runOnChange:true
CREATE TABLE IF NOT EXISTS users
(
    id       serial PRIMARY KEY,
    username TEXT,
    email    TEXT,
    password text
);

CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    role TEXT
);

INSERT INTO roles (id, role)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');

ALTER TABLE users ADD COLUMN user_role int;
ALTER TABLE users ADD CONSTRAINT user_role_fk FOREIGN KEY (user_role) REFERENCES roles (id);

CREATE TABLE IF NOT EXISTS artists
(
    id                  BIGINT PRIMARY KEY,
    first_name          TEXT,
    last_name           TEXT,
    years_of_experience INT,
    education           TEXT,
    user_id             INT
);

ALTER TABLE artists
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE IF NOT EXISTS vacancies
(
    id           BIGSERIAL NOT NULL PRIMARY KEY,
    title        TEXT      NOT NULL,
    description  TEXT,
    date_posted  TIMESTAMP,
    date_updated TIMESTAMP
);

CREATE TABLE IF NOT EXISTS artist_vacancies
(
    artist_id  BIGINT NOT NULL,
    vacancy_id BIGINT NOT NULL
);

ALTER TABLE artist_vacancies
    ADD CONSTRAINT artist_fk FOREIGN KEY (artist_id) REFERENCES artists (id);
ALTER TABLE artist_vacancies
    ADD CONSTRAINT vacancy_fk FOREIGN KEY (vacancy_id) REFERENCES vacancies (id);

CREATE TABLE  IF NOT EXISTS reviews
(
    id        BIGSERIAL NOT NULL PRIMARY KEY,
    message   TEXT      NOT NULL,
    title     TEXT,
    mark      INT,
    artist_id BIGINT
);

ALTER TABLE reviews
    ADD CONSTRAINT artist_fk FOREIGN KEY (artist_id) REFERENCES artists (id);

--changeset Liz:2 runOnChange:true
CREATE TABLE users_roles (
    user_id int,
    roles_id int
);
ALTER TABLE users_roles ADD CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE users_roles ADD CONSTRAINT role_id_fk FOREIGN KEY (roles_id) REFERENCES roles (id);

--changeset Liz:3
ALTER TABLE users ADD COLUMN is_expired boolean;
ALTER TABLE users ADD COLUMN registration_date timestamp;
