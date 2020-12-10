DROP DATABASE library;

CREATE DATABASE IF NOT EXISTS library CHARACTER SET UTF8 COLLATE utf8_bin;

USE library;

CREATE TABLE IF NOT EXISTS images
(
    id   INT         NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id        INT AUTO_INCREMENT,
    login     VARCHAR(45) NOT NULL UNIQUE,
    password  VARCHAR(16) NOT NULL,
    firstname VARCHAR(45) NOT NULL,
    surname   VARCHAR(45) NOT NULL,
    role      ENUM ('reader','librarian','admin'),
    status    ENUM ('enable','blocked') DEFAULT 'enable',

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS books
(
    id       INT AUTO_INCREMENT,
    title    VARCHAR(50)  NOT NULL UNIQUE,
    author   VARCHAR(100) NOT NULL,
    pages    INT          NOT NULL,
    year     YEAR         NOT NULL,
    amount   INT,
    image_id INT          NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (image_id)
        REFERENCES images (id)
);

CREATE TABLE IF NOT EXISTS orders
(
    id          INT AUTO_INCREMENT,
    issue_date  DATE,
    return_date DATE,
    status      ENUM ('accepted','refused','under_consideration') DEFAULT 'under_consideration',

    user_id     INT NOT NULL,
    book_id     INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);