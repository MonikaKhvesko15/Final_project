USE library;

/*--------------filling in the table "users"---------------------*/

INSERT INTO users (login, password, firstname, surname, role)
VALUES ('reader', SHA1('qwerty'), 'Monika', 'Khvesko', 'READER');

INSERT INTO users (login, password, firstname, surname, role)
VALUES ('user1', SHA1('123'), 'Alice', 'Simmons', 'READER');

INSERT INTO users (login, password, firstname, surname, role)
VALUES ('librarian', SHA1('12345'), 'Adrian', 'Watkins', 'LIBRARIAN');

INSERT INTO users (login, password, firstname, surname, role, isBlocked)
VALUES ('user2', SHA1('123'), 'Gloria', 'Bailey', 'LIBRARIAN', 1);

INSERT INTO users (login, password, firstname, surname, role)
VALUES ('admin', SHA1('11111'), 'Nicole', 'Rivera', 'ADMIN');

/*--------------filling in the table "publishers"---------------------*/

INSERT INTO publishers (name, establish_year)
VALUES ('Penguin Random House', 2013);

INSERT INTO publishers (name, establish_year)
VALUES ('Hachette Livre', 1992);

INSERT INTO publishers (name, establish_year)
VALUES ('HarperCollins', 1989);

INSERT INTO publishers (name, establish_year)
VALUES ('Macmillan Publishers', 2015);

INSERT INTO publishers (name, establish_year)
VALUES ('Simon & Schuster', 1924);

/*--------------filling in the table "books"---------------------*/

INSERT INTO books (title, author, pages, amount, publisher_id)
VALUES ('Jane Eyre', 'Charlotte Bronte', 217, 28, 1);

INSERT INTO books (title, author, pages, publisher_id)
VALUES ('Pride and Prjudice', 'Jane Austen', 291, 2);

INSERT INTO books (title, author, pages, amount, publisher_id)
VALUES ('Great Expectations', 'Charles Dickens', 696, 16, 3);

INSERT INTO books (title, author, pages, amount, publisher_id, isDeleted)
VALUES ('Emma', 'Jane Austen', 636, 55, 4, 1);

INSERT INTO books (title, author, pages, amount, publisher_id, isDeleted)
VALUES ('Romeo and Juliet', 'William Shakespeare', 329, 66, 5, 1);

INSERT INTO books (title, author, pages,  publisher_id)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 345, 1);

INSERT INTO books (title, author, pages, amount, publisher_id)
VALUES ('Candide', 'Voltaire', 374, 34, 2);

INSERT INTO books (title, author, pages, amount, publisher_id)
VALUES ('Anna Karenina', 'Leo Tolstoy', 523, 40, 3);

INSERT INTO books (title, author, pages, amount, publisher_id)
VALUES ('Dracula', 'Bram Stoker', 322, 2, 4);

INSERT INTO books (title, author, pages, amount, publisher_id)
VALUES ('War and Peace', 'Leo Tolstoy', 416, 90, 5);

/*--------------filling in the table "orders"---------------------*/

INSERT INTO orders (issue_date, return_date, status, user_id, book_id)
VALUES ('2020-12-01', '2020-12-20','ACCEPTED', 1, 1);

INSERT INTO orders (issue_date, return_date, status, user_id, book_id)
VALUES ('2020-11-01', '2020-12-01', 'UNDER_CONSIDERATION', 3, 2);

INSERT INTO orders (issue_date, return_date, status, user_id, book_id)
VALUES ('2020-11-29', '2020-12-31','ACCEPTED', 4, 8);

INSERT INTO orders (issue_date, return_date, status, user_id, book_id)
VALUES ('2020-06-01', '2020-06-01','COMPLETED', 1, 10);

INSERT INTO orders (issue_date, return_date,status, user_id, book_id)
VALUES ('2020-10-15', '2020-11-15','COMPLETED', 1, 7);