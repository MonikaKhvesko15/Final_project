DROP DATABASE library;

CREATE DATABASE IF NOT EXISTS library CHARACTER SET UTF8 COLLATE utf8_bin;

USE library;

CREATE TABLE IF NOT EXISTS publishers
(
    id   INT         AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    year YEAR        NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id        INT AUTO_INCREMENT,
    login     VARCHAR(45) NOT NULL UNIQUE,
    password  VARCHAR(16) NOT NULL,
    firstname VARCHAR(45) NOT NULL,
    surname   VARCHAR(45) NOT NULL,
    role      ENUM ('READER','LIBRARIAN','ADMIN'),
    status    BIT                         DEFAULT 0,

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS books
(
    id           INT AUTO_INCREMENT,
    title        VARCHAR(50)  NOT NULL UNIQUE,
    author       VARCHAR(100) NOT NULL,
    pages        INT          NOT NULL,
    amount       INT,
    publisher_id INT          NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (publisher_id)
        REFERENCES publishers (id)
);

CREATE TABLE IF NOT EXISTS orders
(
    id          INT AUTO_INCREMENT,
    issue_date  DATE,
    return_date DATE,
    status      ENUM ('ACCEPTED','REFUSED','UNDER_CONSIDERATION') DEFAULT 'UNDER_CONSIDERATION',

    user_id     INT NOT NULL,
    book_id     INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);