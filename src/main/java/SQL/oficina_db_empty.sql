DROP DATABASE IF EXISTS oficina;
CREATE DATABASE oficina;
USE oficina;

DROP TABLE IF EXISTS users;

CREATE table users (
	user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(45) NOT NULL,
    user_login VARCHAR(35) NOT NULL,
    user_password VARCHAR(45) NOT NULL,
    user_email VARCHAR(45) NOT NULL,
    user_role ENUM('admin', 'manager', 'employee') NOT NULL,
    PRIMARY KEY(user_id)
);

DROP TABLE IF EXISTS orders;

SET @@time_zone = 'SYSTEM';

CREATE table orders (
    order_id INT NOT NULL AUTO_INCREMENT,
    order_customer_name VARCHAR(45) NOT NULL,
    order_customer_phone VARCHAR(45) NOT NULL,
    order_total DECIMAL(10,2) NOT NULL,
    order_status ENUM('opened', 'closed'),
    user_id INT NOT NULL,
    created_at DATETIME NOT NULL,
    closed_at DATETIME,
    PRIMARY KEY(order_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id)
);

DROP TABLE IF EXISTS products;

CREATE table products(
	product_id INT NOT NULL AUTO_INCREMENT,
    product_name VARCHAR(45) NOT NULL,
    product_description VARCHAR(250) NOT NULL,
    product_price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(product_id)
);

DROP TABLE IF EXISTS order_product;

CREATE table order_product(
	order_id INT NOT NULL,
    product_id INT NOT NULL,
    FOREIGN KEY(order_id) REFERENCES orders(order_id),
    FOREIGN KEY(product_id) REFERENCES products(product_id)
);