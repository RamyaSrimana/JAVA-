CREATE DATABASE expense_db;
USE expense_db;
CREATE TABLE expense (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    amount DOUBLE,
    category VARCHAR(50),
    expense_date DATE
);