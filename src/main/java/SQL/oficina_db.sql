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

DROP TABLE IF EXISTS customers;

CREATE table customers (
    customer_id INT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(45) NOT NULL,
    customer_phone VARCHAR(45) NOT NULL,
    customer_address VARCHAR(60),
    PRIMARY KEY(customer_id)
);

DROP TABLE IF EXISTS orders;

SET @@time_zone = 'SYSTEM';

CREATE table orders (
    order_id INT NOT NULL AUTO_INCREMENT,
    order_total DECIMAL(10,2) NOT NULL,
    order_status ENUM('opened', 'closed'),
    user_id INT NOT NULL,
    customer_id INT NOT NULL,
    created_at DATETIME NOT NULL,
    closed_at DATETIME,
    PRIMARY KEY(order_id),
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id),
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

INSERT INTO users (user_name, user_login, user_password, user_email, user_role) VALUES ("admin","admin","admin123","admin@email.com","admin");
INSERT INTO users (user_name, user_login, user_password, user_email, user_role) VALUES ("gerente","gerente","gerente123","gerente@email.com","manager");
INSERT INTO users (user_name, user_login, user_password, user_email, user_role) VALUES ("user","user","user123","user@email.com","employee");
INSERT INTO customers (customer_name, customer_phone, customer_address) VALUES ("cliente", "(11)99999-9999", "Rua Legal 123");
INSERT INTO orders (user_id, customer_id, order_total, order_status, created_at) VALUES (3, 1, 300, "opened", '2021-03-25 10:10:10');
INSERT INTO products (product_name, product_description, product_price) VALUES ("Produto 1", "DescriÃ§Ã£o do produto 1", 200.99);
INSERT INTO order_product (order_id, product_id) VALUES (1, 1);