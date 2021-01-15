DROP DATABASE library;

CREATE DATABASE IF NOT EXISTS library CHARACTER SET UTF8 COLLATE utf8_bin;

USE library;

CREATE TABLE IF NOT EXISTS publishers
(
    id             INT AUTO_INCREMENT,
    name           VARCHAR(45) NOT NULL,
    establish_year YEAR        NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id        INT AUTO_INCREMENT,
    login     VARCHAR(20) NOT NULL UNIQUE,
    password  VARCHAR(50) NOT NULL,
    firstname VARCHAR(20) NOT NULL,
    surname   VARCHAR(20) NOT NULL,
    role      ENUM ('GUEST','READER','LIBRARIAN','ADMIN'),
    isBlocked BIT DEFAULT 0,

    PRIMARY KEY (id),
    CONSTRAINT united_name_surname UNIQUE (firstname, surname)
);

CREATE TABLE IF NOT EXISTS books
(
    id           INT AUTO_INCREMENT,
    title        VARCHAR(50) NOT NULL,
    author       VARCHAR(50) NOT NULL,
    pages        INT         NOT NULL,
    amount       INT DEFAULT 0,
    publisher_id INT         NOT NULL,
    isDeleted    BIT DEFAULT 0,
    PRIMARY KEY (id),
    CONSTRAINT united_title_status UNIQUE (title, isDeleted),
    FOREIGN KEY (publisher_id)
        REFERENCES publishers (id)
);

CREATE TABLE IF NOT EXISTS orders
(
    id          INT AUTO_INCREMENT,
    issue_date  DATE NOT NULL,
    return_date DATE NOT NULL,
    status      ENUM ('ACCEPTED','UNDER_CONSIDERATION','COMPLETED','REJECTED') DEFAULT 'UNDER_CONSIDERATION',
    type        ENUM ('READER_ROOM','SUBSCRIPTION') NOT NULL,
    user_id     INT  NOT NULL,
    book_id     INT  NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);