USE library;


INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('user123', '12345', 'Peter', 'Butler', 'READER',0);

INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('alice111', 'abc321', 'Alice', 'Simmons', 'READER', 1);

INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('user', 'user', 'Adrian', 'Watkins', 'LIBRARIAN',0);

INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('gloria15', '141414', 'Gloria', 'Bailey', 'LIBRARIAN', 1);

INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('nic34', '11111', 'Nicole', 'Rivera', 'ADMIN',0);

INSERT INTO users (login, password, firstname, surname, role, status)
VALUES ('admin', 'admin', 'Alberto', 'Jenkins', 'ADMIN', 1);

INSERT INTO publishers (name, year)
VALUES ('Penguin Random House', 2013);
INSERT INTO publishers (name, year)
VALUES ('Hachette Livre', 1992);
INSERT INTO publishers (name, year)
VALUES ('HarperCollins', 1989);
INSERT INTO publishers (name, year)
VALUES ('Macmillan Publishers', 2015);
INSERT INTO publishers (name, year)
VALUES (' Simon & Schuster', 1924);



INSERT INTO books (title, author, pages, amount, publisher_id)
VALUES ('Jane Eyre', 'Charlotte Bronte', 217, 28, 1);

INSERT INTO books (title, author, pages,  amount, publisher_id)
VALUES ('Pride and Prjudice', 'Jane Austen', 291, 88, 2);

INSERT INTO books (title, author, pages, amount, publisher_id)
VALUES ('Great Expectations', 'Charles Dickens', 696, 16, 3);

INSERT INTO books (title, author, pages,  amount, publisher_id)
VALUES ('Emma', 'Jane Austen', 636, 55, 4);

INSERT INTO books (title, author, pages,  amount, publisher_id)
VALUES ('Romeo and Juliet', 'William Shakespeare', 329,66, 5);

INSERT INTO books (title, author, pages,  amount, publisher_id)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 345, 98, 1);

INSERT INTO books (title, author, pages,  amount, publisher_id)
VALUES ('Candide', 'Voltaire', 374, 34, 2);

INSERT INTO books (title, author, pages, amount, publisher_id)
VALUES ('Anna Karenina', 'Leo Tolstoy', 523,40, 3);

INSERT INTO books (title, author, pages,  amount, publisher_id)
VALUES ('Dracula', 'Bram Stoker', 322, 76, 4);

INSERT INTO books (title, author, pages,  amount, publisher_id)
VALUES ('War and Peace', 'Leo Tolstoy', 416, 90, 5);
