-- V1: Create all tables

CREATE TABLE country (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    continent VARCHAR(255) NOT NULL
);

CREATE TABLE author (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    country_id BIGINT REFERENCES country(id)
);

CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL,
    author_id BIGINT REFERENCES author(id),
    state VARCHAR(50) NOT NULL,
    available_copies INTEGER NOT NULL
);
