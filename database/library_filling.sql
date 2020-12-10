USE library;


INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('user123', '12345', 'Peter', 'Butler', 'reader', 'enable');

INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('alice111', 'abc321', 'Alice', 'Simmons', 'reader', 'blocked');

INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('user', 'user', 'Adrian', 'Watkins', 'librarian', 'enable');

INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('gloria15', '141414', 'Gloria', 'Bailey', 'librarian', 'blocked');

INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('nic34', '11111', 'Nicole', 'Rivera', 'admin', 'enable');

INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('admin', 'admin', 'Alberto', 'Jenkins', 'admin', 'blocked');

INSERT INTO images (name)
VALUES ("");
INSERT INTO images (name)
VALUES ("");
INSERT INTO images (name)
VALUES ("");
INSERT INTO images (name)
VALUES ("");
INSERT INTO images (name)
VALUES ("");
INSERT INTO images (name)
VALUES ("");
INSERT INTO images (name)
VALUES ("");
INSERT INTO images (name)
VALUES ("");
INSERT INTO images (name)
VALUES ("");
INSERT INTO images (name)
VALUES ("");


insert into images (image_name)
values ("bac4ee48-8a79-45c7-9c9f-a0e0f7e9e3bd");
insert into images (image_name)
values ("29942f96-44a0-4cc2-a4e0-59dea7b9ce8d");
insert into images (image_name)
values ("a8e08e93-4733-4ae8-ac78-ca37d2627813");
insert into images (image_name)
values ("f775d326-b776-4584-a141-3376ec291a3f");
insert into images (image_name)
values ("6f429a4c-c5c7-48d2-940c-475310bb93fd");
insert into images (image_name)
values ("65731a8c-487b-4811-babf-288f25c73318");

INSERT INTO books (title, author, pages, year, amount, image_id)
VALUES ('Jane Eyre', 'Charlotte Bronte', 217, 1969, 28, 1);

INSERT INTO books (title, author, pages, year, amount, image_id)
VALUES ('Pride and Prjudice', 'Jane Austen', 291, 2000, 88, 2);

INSERT INTO books (title, author, pages, year, amount, image_id)
VALUES ('Great Expectations', 'Charles Dickens', 696, 1967, 16, 3);

INSERT INTO books (title, author, pages, year, amount, image_id)
VALUES ('Emma', 'Jane Austen', 636, 1972, 55, 4);

INSERT INTO books (title, author, pages, year, amount, image_id)
VALUES ('Romeo and Juliet', 'William Shakespeare', 329, 1982, 66, 5);

INSERT INTO books (title, author, pages, year, amount, image_id)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 345, 1961, 98, 6);

INSERT INTO books (title, author, pages, year, amount, image_id)
VALUES ('Candide', 'Voltaire', 374, 1954, 34, 7);

INSERT INTO books (title, author, pages, year, amount, image_id)
VALUES ('Anna Karenina', 'Leo Tolstoy', 523, 1971, 40, 8);

INSERT INTO books (title, author, pages, year, amount, image_id)
VALUES ('Dracula', 'Bram Stoker', 322, 1966, 76, 9);

INSERT INTO books (title, author, pages, year, amount, image_id)
VALUES ('War and Peace', 'Leo Tolstoy', 416, 1988, 90, 10);
