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
    login     VARCHAR(45) NOT NULL UNIQUE,
    password  VARCHAR(50) NOT NULL,
    firstname VARCHAR(45) NOT NULL,
    surname   VARCHAR(45) NOT NULL,
    role      ENUM ('READER','LIBRARIAN','ADMIN'),
    isBlocked BIT DEFAULT 0,

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS books
(
    id           INT AUTO_INCREMENT,
    title        VARCHAR(50)  NOT NULL UNIQUE,
    author       VARCHAR(100) NOT NULL,
    pages        INT          NOT NULL,
    amount       INT DEFAULT 0,
    publisher_id INT          NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (publisher_id)
        REFERENCES publishers (id)
);

CREATE TABLE IF NOT EXISTS orders
(
    id          INT AUTO_INCREMENT,
    issue_date  DATE NOT NULL,
    return_date DATE NOT NULL,
    status      ENUM ('ACCEPTED','FINISHED','UNDER_CONSIDERATION') DEFAULT 'UNDER_CONSIDERATION',
    type        ENUM ('READER_ROOM','SUBSCRIPTION') DEFAULT 'READER_ROOM',
    user_id     INT NOT NULL,
    book_id     INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);