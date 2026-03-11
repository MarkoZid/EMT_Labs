-- V2: Insert initial sample data

-- Countries
INSERT INTO country (name, continent) VALUES ('Macedonia', 'Europe');
INSERT INTO country (name, continent) VALUES ('United Kingdom', 'Europe');
INSERT INTO country (name, continent) VALUES ('United States', 'North America');

-- Authors
INSERT INTO author (created_at, updated_at, name, surname, country_id)
VALUES (NOW(), NOW(), 'Blaze', 'Koneski', 1);

INSERT INTO author (created_at, updated_at, name, surname, country_id)
VALUES (NOW(), NOW(), 'J.K.', 'Rowling', 2);

INSERT INTO author (created_at, updated_at, name, surname, country_id)
VALUES (NOW(), NOW(), 'Stephen', 'King', 3);

-- Books
INSERT INTO book (created_at, updated_at, name, category, author_id, state, available_copies)
VALUES (NOW(), NOW(), 'Lozje', 'CLASSICS', 1, 'GOOD', 5);

INSERT INTO book (created_at, updated_at, name, category, author_id, state, available_copies)
VALUES (NOW(), NOW(), 'Harry Potter', 'FANTASY', 2, 'GOOD', 10);

INSERT INTO book (created_at, updated_at, name, category, author_id, state, available_copies)
VALUES (NOW(), NOW(), 'The Shining', 'THRILER', 3, 'GOOD', 3);
