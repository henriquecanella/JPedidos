CREATE DATABASE oficina;
USE oficina;

DROP TABLE IF EXISTS users;

CREATE table users (
	user_id INT NOT NULL,
    user_name VARCHAR(45) NOT NULL,
    user_login VARCHAR(35) NOT NULL,
    user_password VARCHAR(45) NOT NULL,
    user_email VARCHAR(45) NOT NULL,
    user_role ENUM('admin', 'ger', 'func') NOT NULL,
    PRIMARY KEY(user_id)
);

DROP TABLE IF EXISTS orders;

CREATE table orders (
	order_id INT NOT NULL,
    order_amount INT NOT NULL,
    order_customer_name VARCHAR(45) NOT NULL,
    order_customer_phone VARCHAR(45) NOT NULL,
    order_total DECIMAL(10,2) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY(order_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id)
);

DROP TABLE IF EXISTS products;

CREATE table products(
	product_id INT NOT NULL,
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
INSERT INTO orders (order_amount, order_customer_name, order_customer_phone, user_id) VALUES (1,"Cleyton", "(11)99999-9999",3);
INSERT INTO products (product_name, product_description, product_price) VALUES ("Produto 1", "DescriÃ§Ã£o do produto 1", 200.99);