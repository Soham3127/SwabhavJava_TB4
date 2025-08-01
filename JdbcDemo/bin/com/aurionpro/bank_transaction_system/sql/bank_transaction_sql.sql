CREATE DATABASE IF NOT EXISTS mybank;
USE mybank;

DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS admin;

CREATE TABLE IF NOT EXISTS accounts (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10),
    phone VARCHAR(10) NOT NULL,
    pin INT NOT NULL,
    balance INT NOT NULL,
    is_active BOOLEAN NOT NULL,
    wrong_attempts INT NOT NULL
);

CREATE TABLE IF NOT EXISTS transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    type VARCHAR(50) NOT NULL,
    amount INT NOT NULL,
    timestamp DATETIME NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);

CREATE TABLE IF NOT EXISTS admin (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL
);

INSERT INTO admin (username, password) VALUES ('admin', 'admin123');

SELECT * FROM transactions

INSERT INTO accounts (id, name, age, gender, phone, pin, balance, is_active, wrong_attempts) VALUES
(101, 'Soham Jagtap', 24, 'Male', '9876543210', 1234, 1500, true, 0),
(102, 'Aarav Mehta', 30, 'Male', '9123456789', 5678, 800, true, 2),
(103, 'Neha Sharma', 28, 'Female', '9988776655', 4321, 2000, false, 5),
(104, 'Rohan Patel', 35, 'Male', '6789456778', 8765, 1200, true, 0),
(105, 'Sneha Desai', 23, 'Female', '5678954389', 3456, 300, true, 1);


INSERT INTO transactions (account_id, type, amount, timestamp) VALUES
(101, 'Deposit', 1000, '2025-07-31 14:30:00'),
(101, 'Withdraw', 500, '2025-07-31 15:00:00'),
(102, 'Deposit', 800, '2025-07-31 16:00:00'),
(104, 'Transfer to 105', 300, '2025-07-31 17:00:00'),
(105, 'Received from 104', 300, '2025-07-31 17:00:00');