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
