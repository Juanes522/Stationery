CREATE DATABASE rositastationery;
USE rositastationery;

CREATE TABLE supplier(
	id_supplier INT AUTO_INCREMENT NOT NULL UNIQUE,
    name_supplier VARCHAR(60) NOT NULL UNIQUE,
    address VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    PRIMARY KEY(id_supplier)
);

CREATE TABLE product(
	id_product INT AUTO_INCREMENT NOT NULL,
    name_product VARCHAR(40) NOT NULL,
    price DOUBLE NOT NULL,
    cost DOUBLE NOT NULL,
    quantity INT NOT NULL,
    id_supplier INT NOT NULL,
    PRIMARY KEY(id_product),
    FOREIGN KEY(id_supplier) REFERENCES supplier(id_supplier) ON DELETE CASCADE
);

CREATE TABLE user_stationery(
	id_user INT AUTO_INCREMENT NOT NULL,
    name_user VARCHAR(45) NOT NULL UNIQUE,
    password_user VARCHAR(255) NOT NULL,
    question VARCHAR(80),
    answer VARCHAR(80),
    is_administrator BOOLEAN NOT NULL,
    PRIMARY KEY(id_user)
);

CREATE TABLE sale(
	id_sale INT AUTO_INCREMENT NOT NULL,
    sale_date DATE NOT NULL,
    total_pay DOUBLE NOT NULL,
    seller VARCHAR(45) NOT NULL,
    PRIMARY KEY(id_sale)
);

CREATE TABLE sale_product(
	id_sale INT NOT NULL,
    id_product INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY(id_sale, id_product),
    FOREIGN KEY(id_sale) REFERENCES sale(id_sale) ON DELETE CASCADE,
    FOREIGN KEY(id_product) REFERENCES product(id_product) ON DELETE CASCADE
);

CREATE TABLE purchase(
	id_purchase INT AUTO_INCREMENT NOT NULL,
    purchase_date DATE NOT NULL,
    total_pay DOUBLE NOT NULL,
    PRIMARY KEY(id_purchase)
);

CREATE TABLE purchase_product(
	id_purchase INT NOT NULL,
    id_product INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY(id_purchase, id_product),
    FOREIGN KEY(id_purchase) REFERENCES purchase(id_purchase) ON DELETE CASCADE,
    FOREIGN KEY(id_product) REFERENCES product(id_product) ON DELETE CASCADE
);
INSERT INTO user_stationery (name_user, password_user, question, answer, is_administrator) VALUES ("admin", "dest","nombre?","juan", true);